package guitarscoreboardapi.entity.primarykey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ScoreAccessesPK implements Serializable {

    @Column(name = "score_id")
    private Integer scoreId;
    @Column(name = "created_at")
    private Date createdAt;
}
