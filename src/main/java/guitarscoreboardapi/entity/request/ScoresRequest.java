package guitarscoreboardapi.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoresRequest {
    @NotEmpty
    private String title;
    @NotEmpty
    private String score;
    private String lyricist;
    private String composer;
    private String arranger;
    private String vocalist;
    @NotEmpty
    private String poster;
}
