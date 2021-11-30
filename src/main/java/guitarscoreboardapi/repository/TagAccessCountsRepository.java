package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.TagAccessCounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TagAccessCountsRepository extends JpaRepository<TagAccessCounts,Integer>, JpaSpecificationExecutor<TagAccessCounts> {
}
