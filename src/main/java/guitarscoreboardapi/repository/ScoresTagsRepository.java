package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.ScoresTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoresTagsRepository extends JpaRepository<ScoresTags,Integer>, JpaSpecificationExecutor<ScoresTags> {
}
