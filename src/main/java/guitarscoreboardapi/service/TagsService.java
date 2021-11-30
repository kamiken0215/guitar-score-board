package guitarscoreboardapi.service;

import guitarscoreboardapi.entity.Tags;
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

    public Optional<Tags> findById(Integer id) {
        return tagsRepository.findById(id);
    }

}
