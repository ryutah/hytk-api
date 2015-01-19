package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ryuta on 15/01/18.
 */
@Entity
public class CategoryBlogData extends Model {

    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    public CategoryData categoryData;

    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    @JsonBackReference
    public BlogData blogData;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

}
