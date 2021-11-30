package guitarscoreboardapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score_access_counts")
@Data
public class ScoreAccessCounts {
    @Id
    @Column(name = "score_id")
    private Integer scoreId;

    @OneToOne
    @JoinColumn(name = "score_id")
    private Scores scores;

    @Column(name = "weekly_access_count")
    private Integer weeklyAccessCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private Date updatedAt;
}
