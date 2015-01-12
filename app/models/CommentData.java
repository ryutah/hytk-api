package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
public class CommentData extends Model {

    public Long id;

    public BlogData blogId;

    public String name;

    public String content;

    public Date create;

    public Date update;
}
