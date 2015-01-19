package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
@Entity
public class CommentData extends Model {

    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    @JsonBackReference
    public BlogData blogData;

    @Constraints.MaxLength(50)
    @Column(name = "comment_name", length = 50)
    public String name;

    @Constraints.MaxLength(50)
    @Column(name = "comment_title", length = 50)
    public String title;

    @Column(name = "comment_content", columnDefinition = "TEXT")
    @Constraints.Required
    @NotNull
    public String content;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

}
