package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
<<<<<<< .merge_file_AIbhNc
public class CategoryData {
=======
public class CategoryData extends Model{

    public Long id;

    public String category;

    public Date create;

    public Date update;

    public static Finder<Long, CategoryData> find =
            new Finder<Long, CategoryData>(Long.class, CategoryData.class);
>>>>>>> .merge_file_rQk9nb
}
