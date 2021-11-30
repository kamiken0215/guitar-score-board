package guitarscoreboardapi.entity.primarykey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ScoresTagsPK implements Serializable {

    @Column(name = "score_id")
    private Integer scoreId;
    @Column(name = "tag_id")
    private Integer tagId;
}
