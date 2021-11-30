package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.Scores;
import guitarscoreboardapi.entity.ScoresView;
import org.springframework.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ScoresSpecifications {

    public static Specification<Scores> equalId(Integer id) {
        return id == null ? null : (root, query, cb) ->
                cb.equal(root.<Integer>get("id"), id);
    }

    public static Specification<ScoresView> titleContains(String title) {
        return !StringUtils.hasText(title) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("title"),"%"+title+"%");
    }
    public static Specification<ScoresView> lyricistContains(String lyricist) {
        return !StringUtils.hasText(lyricist) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("lyricist"),"%"+lyricist+"%");
    }
    public static Specification<ScoresView> composerContains(String composer) {
        return !StringUtils.hasText(composer) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("composer"),"%"+composer+"%");
    }
    public static Specification<ScoresView> arrangerContains(String arranger) {
        return !StringUtils.hasText(arranger) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("arranger"),"%"+arranger+"%");
    }
    public static Specification<ScoresView> vocalistContains(String vocalist) {
        return !StringUtils.hasText(vocalist) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("vocalist"),"%"+vocalist+"%");
    }
    public static Specification<ScoresView> posterContains(String poster) {
        return !StringUtils.hasText(poster) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("poster"),"%"+poster+"%");
    }
    public static Specification<ScoresView> tagNameContains(String name) {
        return !StringUtils.hasText(name) ? null : (Specification<ScoresView>)  (root, query, cb) ->
                cb.like(root.get("name"),"%"+name+"%");
    }
}
