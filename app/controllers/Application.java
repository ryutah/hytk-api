package controllers;

import models.TestModel;
import models.TestParent;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result getModel() {
        TestModel testModel = new TestModel();
        testModel.setName("ryuta");

        TestParent parent = new TestParent();
        parent.parentName = "test";
        parent.save();

        parent.addChild(testModel);
//
//        testModel.save();

        Logger.info("----------New TestModel ID-----------");
        Logger.info(testModel.getId().toString());
        Logger.info("-------------------------------------");

        List<TestModel> models = TestModel.find.all();

        Logger.info("---------------Find ID----------------");
        TestModel.getIds().stream().forEach(s -> {
            String str = Json.toJson(s).toString();
            Logger.info("Model = " + str);
        });
        Logger.info("--------------------------------------");

        return ok(Json.toJson(models));
    }

    public static Result getName(String name) {
        List<TestModel> models = TestModel.getList(name);

        return ok(Json.toJson(models));
    }
}
