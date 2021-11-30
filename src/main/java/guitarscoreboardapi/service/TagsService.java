package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.Tags;
import guitarscoreboardapi.model.TagsModel;
import guitarscoreboardapi.repository.TagsRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    public List<Tags> findAll() {return tagsRepository.findAll();}
    public Optional<Tags> findById(Integer id) {
        return tagsRepository.findById(id);
    }
    public Tags create(Tags tags) {
        return tagsRepository.save(tags);
    }
    public void delete(int id) {
        tagsRepository.deleteById(id);
    }

}
