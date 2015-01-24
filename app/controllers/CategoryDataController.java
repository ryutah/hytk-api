package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.CategoryData;
import org.springframework.beans.factory.annotation.Autowired;
import params.category.GetCategoryListParam;
import params.category.GetCategoryParam;
import params.category.PostCategoryParam;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CategoryDataService;

import java.util.List;

/**
 * Created by ryuta on 15/01/11.
 */
@org.springframework.stereotype.Controller
public class CategoryDataController extends Controller {

    @Autowired
    CategoryDataService categoryDataService;

    public Result postCategory() {
        JsonNode json = request().body().asJson();
        Form<PostCategoryParam> form = Form.form(PostCategoryParam.class).bind(json);

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        categoryDataService.savaCategory(form.get().category);

        return created();
    }

    public Result getCategoryList() {
        JsonNode json = Json.parse(request().getQueryString("p"));
        Form<GetCategoryListParam> form = Form.form(GetCategoryListParam.class).bind(json);

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        List<CategoryData> categoryDataList = categoryDataService.getCategoryList(form.get().category);

        String result = Json.toJson(categoryDataList).toString();

        return ok(result);
    }

    public Result getCategory(String id) {
        String param = "{\"id\":" + id + "}";
        JsonNode json = Json.parse(param);
        Form<GetCategoryParam> form = Form.form(GetCategoryParam.class).bind(json);

        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        Long categoryId = Long.valueOf(form.get().id);
        CategoryData categoryData = categoryDataService.getCategory(categoryId);

        String result = Json.toJson(categoryData).toString();

        return ok(result);
    }

    public Result putCategory(String id) {
        JsonNode request = request().body().asJson();

        return ok();
    }
}
