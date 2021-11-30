package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.Scores;
import guitarscoreboardapi.entity.ScoresView;
import guitarscoreboardapi.repository.ScoresRepository;
import guitarscoreboardapi.repository.ScoresViewRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class ScoresService {

    @Autowired
    private ScoresRepository scoresRepository;
    @Autowired
    private ScoresViewRepository scoresViewRepository;

    public List<Scores> find() {
        return scoresRepository.findAll();
    }

    public List<Scores> findById(Integer id) {
        return scoresRepository.findAll(Specification
                .where(ScoresSpecifications.equalId(id))
        );
    }

    public List<Scores> fetchRandom(int limit) {
        return scoresRepository.fetchRandom(limit);
    }

    public List<Scores> findByIdList(List<Integer> scoreIdList) {
        return scoresRepository.findAllById(scoreIdList);
    }

    public List<ScoresView> search(String param) {
        return scoresViewRepository.findAll(Specification
                .where(ScoresSpecifications.titleContains(param))
                .or(ScoresSpecifications.lyricistContains(param))
                .or(ScoresSpecifications.composerContains(param))
                .or(ScoresSpecifications.arrangerContains(param))
                .or(ScoresSpecifications.vocalistContains(param))
                .or(ScoresSpecifications.posterContains(param))
                .or(ScoresSpecifications.tagNameContains(param))
                ,Sort.by(Sort.Direction.ASC,"scoreId").and(Sort.by(Sort.Direction.ASC,"tagId"))
        );
    }

    public Scores create(Scores scores) {
        return scoresRepository.save(scores);
    }

    public void delete(Integer id) {
        scoresRepository.deleteById(id);
    }

}
