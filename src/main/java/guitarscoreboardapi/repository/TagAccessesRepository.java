package guitarscoreboardapi.repository;

import guitarscoreboardapi.entity.TagAccesses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TagAccessesRepository extends JpaRepository<TagAccesses,Integer>, JpaSpecificationExecutor<TagAccesses> {
}
