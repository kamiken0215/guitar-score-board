package guitarscoreboardapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import guitarscoreboardapi.entity.primarykey.ScoreAccessesPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score_accesses")
@Data
@IdClass(ScoreAccessesPK.class)
public class ScoreAccesses {

    @Id
    @Column(name = "score_id")
    private Integer scoreId;

    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;
}
