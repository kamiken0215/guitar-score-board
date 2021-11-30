package guitarscoreboardapi.controller;

import guitarscoreboardapi.entity.*;
import guitarscoreboardapi.entity.request.ScoresRequest;
import guitarscoreboardapi.entity.request.ScoresTagsRequest;
import guitarscoreboardapi.model.ScoresModel;
import guitarscoreboardapi.model.TagsModel;
import guitarscoreboardapi.service.ScoreAccessCountsService;
import guitarscoreboardapi.service.ScoreAccessesService;
import guitarscoreboardapi.service.ScoresService;
import guitarscoreboardapi.service.ScoresTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ScoresController {

    @Autowired
    private ScoresService scoresService;
    @Autowired
    private ScoreAccessesService scoreAccessesService;
    @Autowired
    private ScoreAccessCountsService scoreAccessCountsService;
    @Autowired
    private ScoresTagsService scoresTagsService;

    @GetMapping("/scores")
    public List<Scores> findAll() {
        return scoresService.find();
    }

    @GetMapping("/scores/{id}")
    public List<ScoresModel> findById(@PathVariable(value = "id") Integer id) {
        //  アクセス履歴を追加
        createAccessHistory(id);
        List<Scores> scoresList = scoresService.findById(id);
        return createScoreModelList(scoresList);
    }

    @GetMapping("/scores/rand")
    public List<ScoresModel> fetchRandom() {
        List<Integer> searchedScoreIdList = new ArrayList<>();
        //  とりあえず30件ランダムでID生成
        List<Scores> scoresList = scoresService.fetchRandom(30);
        return createScoreModelList(scoresList);
    }

    @GetMapping({"/scores/search","/scores/search/{param}"})
    public List<ScoresModel> search(@PathVariable(value = "param",required = false) String param) {
        List<ScoresView> scoresViews = scoresService.search(param);

        if (scoresViews.size() == 0) {
            return new ArrayList<>();
        }

        List<Integer> searchedScoreIdList = new ArrayList<>();
        scoresViews.stream()
                .collect(Collectors.groupingBy(ScoresView::getScoreId,Collectors.counting()))
                .forEach((k,v) -> {
                    System.out.println(k+"が"+v+"件重複");
                    searchedScoreIdList.add(k);
                });

        List<Scores> scoresList = scoresService.findByIdList(searchedScoreIdList);
        return createScoreModelList(scoresList);
    }

    @GetMapping("/scores/popular/month/{param}")
    public List<ScoresModel> findAll(@PathVariable(value = "param") String param) {
        if (!(param.equals("asc") || param.equals("desc"))) {
            return new ArrayList<>();
        }
        boolean isAsc = param.equals("asc");
        List<ScoreAccessCounts> scoreAccessCountsList = scoreAccessCountsService.find(isAsc);
        List<Scores> scoresList = new ArrayList<>();
        for (ScoreAccessCounts s : scoreAccessCountsList) {
            scoresList.add(s.getScores());
        }
        return createScoreModelList(scoresList);
    }

    //  create
    @PostMapping("/scores")
    public Scores create(HttpServletRequest request, HttpServletResponse response, @RequestBody ScoresRequest s) {
        Scores scores = Scores.builder()
                .title(s.getTitle())
                .score(s.getScore())
                .lyricist(s.getLyricist())
                .composer(s.getComposer())
                .arranger(s.getArranger())
                .vocalist(s.getVocalist())
                .poster(s.getPoster())
                .isEditing("off")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        return scoresService.create(scores);
    }

    //  タグの付与
    @PostMapping("/scores/{id}/tags")
    public List<ScoresTags> createTagsScores(@PathVariable(value = "id") Integer scoreId,@RequestBody ScoresTagsRequest s) {
        List<Integer> tagIds = new ArrayList<>(s.getTagIds());
        List<ScoresTags> scoresTagsList = new ArrayList<>();
        for (Integer tagId: tagIds) {
            ScoresTags scoresTags = ScoresTags.builder()
                    .scoreId(scoreId)
                    .tagId(tagId)
                    .build();
            scoresTagsList.add(scoresTags);
        }
        return scoresTagsService.createScoresTags(scoresTagsList);
    }

    //  update
    @PutMapping("/scores/{id}")
    public Scores update(@PathVariable(value = "id") Integer id,@RequestBody ScoresRequest s) {
        Scores scores = Scores.builder()
                .id(id)
                .title(s.getTitle())
                .score(s.getScore())
                .lyricist(s.getLyricist())
                .composer(s.getComposer())
                .arranger(s.getArranger())
                .vocalist(s.getVocalist())
                .poster(s.getPoster())
                .isEditing("off")
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        return scoresService.create(scores);
    }

    //  delete
    @DeleteMapping("/scores/{id}")
    public void deleteById(@PathVariable(value = "id") Integer id) {
        scoresService.delete(id);
    }

    private void createAccessHistory(Integer id) {
        ScoreAccesses scoreAccesses = ScoreAccesses.builder()
                .scoreId(id)
                .createdAt(new Date())
                .build();
        scoreAccessesService.create(scoreAccesses);
    }

    //  楽曲に付与されたタグ削除
    @DeleteMapping("/scores/{scoreId}/tags/{tagId}")
    public void deleteScoresTags(HttpServletRequest request, HttpServletResponse response,@PathVariable(value = "scoreId") Integer scoreId,@PathVariable(value = "tagId") Integer tagId) {
        List<ScoresTags> scoresTags = scoresTagsService.find(scoreId,tagId);
        if (scoresTags.size() == 1) {
            scoresTagsService.delete(scoresTags.get(0));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private List<ScoresModel> createScoreModelList(List<Scores> scoresList) {

        List<ScoresModel> scoresModelList = new ArrayList<>();
        for (Scores s : scoresList) {
            ScoresModel scoresModel = ScoresModel.builder()
                    .id(s.getId())
                    .title(s.getTitle())
                    .score(s.getScore())
                    .lyricist(s.getLyricist())
                    .composer(s.getComposer())
                    .arranger(s.getArranger())
                    .vocalist(s.getVocalist())
                    .poster(s.getPoster())
                    .createdAt(s.getCreatedAt())
                    .updatedAt(s.getUpdatedAt())
                    .build();
            List<Tags> tags = new ArrayList<>();
            if (s.getScoresTags() != null) {
                tags = s.getScoresTags().stream().map(ScoresTags::getTags).collect(Collectors.toList());
            }
            List<TagsModel> tagsModels = new ArrayList<>();
            if (tags.size() > 0) {
                for(Tags t : tags) {
                    TagsModel tagsModel = TagsModel.builder()
                            .id(t.getId())
                            .name(t.getName())
                            .build();
                    tagsModels.add(tagsModel);
                }
            }
            scoresModel.setTags(tagsModels);
            scoresModelList.add(scoresModel);
        }

        return scoresModelList;

    }


}
