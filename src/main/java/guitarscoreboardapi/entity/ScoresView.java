package guitarscoreboardapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import guitarscoreboardapi.entity.primarykey.ScoresTagsPK;
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
@Table(name = "view_scores")
@Data
@IdClass(ScoresTagsPK.class)
public class ScoresView {

    @Id
    @Column(name = "score_id")
    private Integer scoreId;

    @Column(name = "title")
    private String title;

    @Column(name = "score")
    private String score;

    @Column(name = "lyricist")
    private String lyricist;

    @Column(name = "composer")
    private String composer;

    @Column(name = "arranger")
    private String arranger;

    @Column(name = "vocalist")
    private String vocalist;

    @Column(name = "poster")
    private String poster;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private Date updatedAt;

    @Id
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "name")
    private String name;
}
