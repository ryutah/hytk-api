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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    @JsonBackReference
    public BlogData blogId;

    @Constraints.MaxLength(50)
    @Column(name = "comment_name")
    public String name;

    @Column(name = "comment_title", columnDefinition = "TEXT")
    @Constraints.Required
    @NotNull
    public String content;

    @CreatedTimestamp
    public Date create;

    @Version
    public Date update;

}
