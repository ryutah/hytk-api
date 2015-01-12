package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
<<<<<<< .merge_file_lCidF5
public class BlogTagData {
=======
public class BlogTagData extends Model{

    public Long id;

    public BlogData blogId;

    public TagData tagId;

    public Date create;

    public Date update;
>>>>>>> .merge_file_bKZro5
}
