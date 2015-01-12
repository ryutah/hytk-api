package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
public class TagData extends Model{

    public Long id;

    public String tag;

    public Date create;

    public Date update;

    public static Finder<Long, TagData> find =
            new Finder<Long, TagData>(Long.class, TagData.class);
    
}
