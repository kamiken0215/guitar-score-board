package guitarscoreboardapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagsModel {
    private Integer id;
    private String name;
}
