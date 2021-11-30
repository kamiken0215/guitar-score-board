package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.Scores;
import guitarscoreboardapi.entity.ScoresTags;
import guitarscoreboardapi.entity.ScoresView;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ScoresTagsSpecifications {

    public static Specification<ScoresTags> equalScoreId(Integer scoreId) {
        return scoreId == null ? null : (root, query, cb) ->
                cb.equal(root.<Integer>get("scoreId"), scoreId);
    }

    public static Specification<ScoresTags> equalTagId(Integer tagId) {
        return tagId == null ? null : (root, query, cb) ->
                cb.equal(root.<Integer>get("tagId"), tagId);
    }
}
