package guitarscoreboardapi.controller;

import guitarscoreboardapi.entity.Tags;
import guitarscoreboardapi.model.TagsModel;
import guitarscoreboardapi.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/tags")
    public List<Tags> findAll() {
        return tagsService.findAll();
    }

    @GetMapping("/tags/{id}")
    public Tags findById(@PathVariable(value = "id") Integer id) {
        return tagsService.findById(id).orElse(new Tags());
    }

    @PostMapping("/tags")
    public Tags create(@RequestBody TagsModel tagsModel) {
        Tags tags = Tags.builder()
                .name(tagsModel.getName())
                .build();
        return tagsService.create(tags);
    }

    @DeleteMapping("/tags/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        tagsService.delete(id);
    }

}
