package guitarscoreboardapi.controller;

import guitarscoreboardapi.entity.*;
import guitarscoreboardapi.entity.request.ScoresRequest;
import guitarscoreboardapi.model.ScoresModel;
import guitarscoreboardapi.model.TagsModel;
import guitarscoreboardapi.service.ScoreAccessCountsService;
import guitarscoreboardapi.service.ScoreAccessesService;
import guitarscoreboardapi.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ScoreAccessCountsController {

    @Autowired
    private ScoresService scoresService;
    @Autowired
    private ScoreAccessesService scoreAccessesService;
    @Autowired
    private ScoreAccessCountsService scoreAccessCountsService;

//    @GetMapping("/scores/popular/month/{param}")
//    public List<ScoresModel> findAll(@PathVariable(value = "param") String param) {
//        if (!(param.equals("asc") || param.equals("desc"))) {
//            return new ArrayList<>();
//        }
//        boolean isAsc = param.equals("asc");
//        List<ScoreAccessCounts> scoreAccessCountsList = scoreAccessCountsService.find(isAsc);
//        List<Scores> scoresList = new ArrayList<>();
//        for (ScoreAccessCounts s : scoreAccessCountsList) {
//            scoresList.add(s.getScores());
//        }
//        return createScoreModelList(scoresList);
//    }

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
