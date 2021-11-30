package guitarscoreboardapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tags")
@Data
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contents")
    private String contents;

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

//    @ManyToMany
//    private Set<Scores> scores;
//    @OneToMany(mappedBy = "tags")
//    Set<ScoresTags> scoresTags;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinTable(
//            // 中間テーブル名
//            name="scores_tags",
//            joinColumns = {
//                    /*
//                     * mappings -> rolesの関係を定義
//                     * name=mappingsテーブルのカラム名
//                     * referencedColumnName=roleテーブルのカラム名
//                     */
//                    @JoinColumn(name ="id", referencedColumnName ="tag_id")
//            },
//            inverseJoinColumns = {
//                    /*
//                     * mappings -> usersの関係を定義
//                     * name=mappingsテーブルのカラム名
//                     * referencedColumnName=usersテーブルのカラム名
//                     */
//                    @JoinColumn(name ="id", referencedColumnName ="score_id")
//            }
//    )
//    private List<Scores> scores;

}
