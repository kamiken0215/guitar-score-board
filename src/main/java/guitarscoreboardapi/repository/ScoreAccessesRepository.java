package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.ScoreAccesses;
import guitarscoreboardapi.entity.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScoreAccessesRepository extends JpaRepository<ScoreAccesses,Integer>, JpaSpecificationExecutor<ScoreAccesses> {

    @Query(nativeQuery=true, value="SELECT score_id FROM score_accesses group by score_id")
    List<Integer> findAllScoreId();

    @Query(nativeQuery=true, value="SELECT count(score_id) FROM score_accesses where score_id = ?1 and created_at between ?2 and ?3")
    long countAccesses(Integer id,String start,String last);
}
