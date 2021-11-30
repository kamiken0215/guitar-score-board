package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.ScoreAccessCounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ScoreAccessCountsRepository extends JpaRepository<ScoreAccessCounts,Integer>, JpaSpecificationExecutor<ScoreAccessCounts> {

    @Transactional
    @Modifying
    @Query(nativeQuery=true, value="INSERT INTO guitar.score_access_counts (score_id,weekly_access_count) VALUES (?1,?2)\n" +
            "ON DUPLICATE KEY UPDATE weekly_access_count = VALUES(weekly_access_count);")
    void countUpdate(Integer id, Integer count);
}
