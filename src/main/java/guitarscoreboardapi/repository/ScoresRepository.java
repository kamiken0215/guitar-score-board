package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.Scores;
import guitarscoreboardapi.entity.ScoresView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoresRepository extends JpaRepository<Scores,Integer>, JpaSpecificationExecutor<Scores> {
    @Query(nativeQuery=true, value="SELECT * FROM scores ORDER BY RAND() LIMIT ?1")
    public List<Scores> fetchRandom(Integer limit);
}
