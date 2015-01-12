package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
public class BlogData extends Model {

    public Long id;

    public String title;

    public String content;

    public CategoryData categoryId;

    public Integer status;

    public Date publish;

    public Date create;

    public Date update;
}
