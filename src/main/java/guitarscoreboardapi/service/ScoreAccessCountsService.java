package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.ScoreAccessCounts;
import guitarscoreboardapi.repository.ScoreAccessCountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAccessCountsService {
    @Autowired
    private ScoreAccessCountsRepository scoreAccessCountsRepository;

    public List<ScoreAccessCounts> find (Boolean isAsc) {
        if (isAsc) {
            return scoreAccessCountsRepository.findAll(Sort.by(Sort.Direction.ASC,"weeklyAccessCount"));
        } else {
            return scoreAccessCountsRepository.findAll(Sort.by(Sort.Direction.DESC,"weeklyAccessCount"));
        }

    }

    public void countUpdate(Integer id, Integer count) {
        scoreAccessCountsRepository.countUpdate(id,count);
    }
}
