package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by ryuta on 15/01/11.
 */
@Entity
public class CategoryData extends Model{

    @Id
    public Long id;

    @Constraints.Required
    @NotNull
    @Constraints.MaxLength(20)
    public String category;

    @OneToMany
    @JsonManagedReference
    public List<CategoryBlogData> categoryBlogDatas;

    @CreatedTimestamp
    public Date create;

    @Version
    public Date update;

    public static Finder<Long, CategoryData> find =
            new Finder<Long, CategoryData>(Long.class, CategoryData.class);

}
