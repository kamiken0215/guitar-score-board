package guitarscoreboardapi.entity;

import guitarscoreboardapi.entity.primarykey.ScoresTagsPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scores_tags")
@Data
public class ScoresTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "tag_id")
    private Integer tagId;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "Tag_id",referencedColumnName = "id", insertable = false, updatable = false)
    private Tags tags;

//    @ManyToOne
//    @MapsId("score_id")
//    @JoinColumn(name = "score_id")
//    private Scores scores;
//
//    @ManyToOne
//    @MapsId("tag_id")
//    @JoinColumn(name = "tag_id")
//    private Tags tags;

//    @Id
//    @Column(name = "score_id")
//    private Integer scoreId;
//    @Id
//    @Column(name = "tag_id")
//    private Integer tagId;
}
