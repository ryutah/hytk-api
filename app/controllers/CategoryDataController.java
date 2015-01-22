package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import params.category.GetCategoryListParam;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CategoryDataService;

/**
 * Created by ryuta on 15/01/11.
 */
@org.springframework.stereotype.Controller
public class CategoryDataController extends Controller {

    @Autowired
    CategoryDataService categoryDataService;

    public Result getList() {
        JsonNode json = Json.parse(request().getQueryString("p"));
        Form<GetCategoryListParam> form = Form.form(GetCategoryListParam.class).bind(json);

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        return ok();
    }
}
