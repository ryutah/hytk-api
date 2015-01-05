package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by ryuta on 14/12/30.
 */

@Entity
public class BlogContent extends Model{
    @Id
    public Long id;

    @NotNull
    public String title;

    @Column(name="content", columnDefinition="text")
    @NotNull
    public String content;

    @CreatedTimestamp
    public Date createDate;

    @Version
    public Date updateDate;

    public static Finder<Long, BlogContent> find = new Finder<Long, BlogContent>(Long.class, BlogContent.class);

    public BlogContent() {

    }

    public BlogContent(String content) {
        this.content = content;

    }

    public static Long saveContent(String content) {
        BlogContent blogContent = new BlogContent(content);
        blogContent.save();

        return blogContent.id;
    }

    public static List<BlogContent> findList() {
        return find.select("id, title, createDate, updateDate")
                   .findList();
    }
}
