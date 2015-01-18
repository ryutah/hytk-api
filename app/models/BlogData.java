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
public class BlogData extends Model {
    public static final int Publish = 0;
    public static final int Unpublsh = 1;

    @Id
    public Long id;

    @Constraints.MaxLength(80)
    @Column(name = "blog_title")
    public String title;

    @Column(name = "blog_content", columnDefinition = "LONGTEXT")
    public String content;

    @NotNull
    @Column(columnDefinition = "integer default " + Unpublsh)
    @Constraints.MaxLength(1)
    public Integer status = Unpublsh;

    @OneToMany
    @JoinColumn(name = "blog_id")
    @JsonManagedReference
    public List<BlogTagData> blogTagDataList;

    @OneToMany
    @JoinColumn(name =  "blog_id")
    @JsonManagedReference
    public List<CategoryBlogData> categoryBlogDatas;


    @OneToMany
    @JoinColumn(name = "blog_id")
    @JsonManagedReference
    public List<CommentData> commentDatas;

    public Date publish;

    @CreatedTimestamp
    public Date create;

    @Version
    public Date update;
}
