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
    @Column(name = "blog_title", length = 80)
    public String title;

    @Column(name = "blog_content", columnDefinition = "LONGTEXT")
    public String content;

    @NotNull
    @Column(columnDefinition = "integer default " + Unpublsh, length = 4)
    @Constraints.MaxLength(4)
    public Integer status = Unpublsh;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<BlogTagData> blogTagDatas;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<CategoryBlogData> categoryBlogDatas;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<CommentData> commentDatas;

    public Date publishDate;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;
}
