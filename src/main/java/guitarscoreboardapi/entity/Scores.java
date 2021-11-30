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
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scores")
@Data
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

    @Column(name = "is_editing")
    private String isEditing;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private Date updatedAt;

    @Nullable
    @OneToMany
    @JoinColumn(name = "score_id",referencedColumnName = "id")
    private List<ScoresTags> scoresTags;

//    @ManyToOne
//    @JoinColumn(name = "scores_tags",referencedColumnName = "score_id")
//    private ScoresTags scoresTags;
//    @ManyToMany
//    @JoinTable (
//            name = "scores_tags",
//            joinColumns = @JoinColumn(name = "score_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private Set<Tags> tags;
//    @OneToMany(mappedBy = "scores")
//    Set<ScoresTags> scoresTags;
}
