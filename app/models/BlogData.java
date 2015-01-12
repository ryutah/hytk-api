package models;

<<<<<<< .merge_file_eTEwt5
import play.mvc.Controller;
=======
import play.db.ebean.Model;

import java.util.Date;
import java.util.List;
>>>>>>> .merge_file_dCprj5

/**
 * Created by ryuta on 15/01/11.
 */
<<<<<<< .merge_file_eTEwt5
public class BlogData extends Controller {
=======
public class BlogData extends Model {

    public Long id;

    public String title;

    public String content;

    public List<BlogTagData> blogTagDataList;

    public CategoryData categoryId;

    public Integer status;

    public Date publish;

    public Date create;

    public Date update;
>>>>>>> .merge_file_dCprj5
}
