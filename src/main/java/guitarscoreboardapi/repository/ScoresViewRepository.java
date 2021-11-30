package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.Scores;
import guitarscoreboardapi.entity.ScoresView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoresViewRepository extends JpaRepository<ScoresView,Integer>, JpaSpecificationExecutor<ScoresView> {

}
