package models;

import play.db.ebean.Model;

import java.util.Date;

/**
 * Created by ryuta on 15/01/11.
 */
public class CategoryData extends Model{

    public Long id;

    public String category;

    public Date create;

    public Date update;
}
