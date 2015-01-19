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
    @Column(length = 25)
    @Constraints.Required
    @Constraints.MaxLength(25)
    public String tag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    @JsonManagedReference
    public List<BlogTagData> blogTagDatas;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

    public static Finder<Long, TagData> find =
            new Finder<Long, TagData>(Long.class, TagData.class);
    
}
