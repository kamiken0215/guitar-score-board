package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.ScoresTags;
import guitarscoreboardapi.repository.ScoresTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresTagsService {
    @Autowired
    private ScoresTagsRepository scoresTagsRepository;

    public List<ScoresTags> find(Integer scoreId,Integer tagId) {
        return scoresTagsRepository.findAll(Specification
                    .where(ScoresTagsSpecifications.equalScoreId(scoreId))
                    .and(ScoresTagsSpecifications.equalTagId(tagId))
        );
    }

    public ScoresTags create(ScoresTags scoresTags) {
        return scoresTagsRepository.save(scoresTags);
    }

    public List<ScoresTags> createScoresTags(List<ScoresTags> scoresTags) {
        return scoresTagsRepository.saveAll(scoresTags);
    }

    public void delete(ScoresTags scoresTags) {
        scoresTagsRepository.delete(scoresTags);
    }
}
