package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.ScoreAccesses;
import guitarscoreboardapi.repository.ScoreAccessesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreAccessesService {
    @Autowired
    private ScoreAccessesService scoreAccessesService;
    @Autowired
    private ScoreAccessesRepository scoreAccessesRepository;

    public void create(ScoreAccesses scoreAccesses) {
        scoreAccessesRepository.save(scoreAccesses);
    }

    public List<Integer> findAllId() {
        return scoreAccessesRepository.findAllScoreId();
    }

    public long countAccesses(Integer id,String start,String last) {
        return scoreAccessesRepository.countAccesses(id,start,last);
    }


}
