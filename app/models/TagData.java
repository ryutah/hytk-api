package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by ryuta on 15/01/11.
 */
@Entity
public class TagData extends Model{

    @Id
    public Long id;

    @NotNull
    @Constraints.Required
    @Constraints.MaxLength(25)
    public String tag;

    @OneToMany
    @JoinColumn(name = "tag_id")
    @JsonManagedReference
    public List<BlogTagData> blogTagDatas;

    @CreatedTimestamp
    public Date create;

    @Version
    public Date update;

    public static Finder<Long, TagData> find =
            new Finder<Long, TagData>(Long.class, TagData.class);
    
}
