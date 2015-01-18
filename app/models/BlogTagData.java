package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */

@Entity
public class BlogTagData extends Model{

    @Id
    public Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    @JsonBackReference
    public BlogData blogId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @JsonBackReference
    public TagData tagId;

    @CreatedTimestamp
    public Date create;

    @Version
    public Date update;

}
