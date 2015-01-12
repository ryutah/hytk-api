package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
<<<<<<< .merge_file_JBXXui
public class CommentData {
=======
public class CommentData extends Model {

    public Long id;

    public BlogData blogId;

    public String name;

    public String content;

    public Date create;

    public Date update;
>>>>>>> .merge_file_zvW04h
}
