package controllers;

import services.impl.TestLogicImpl;
import models.TestModel;
import models.TestParent;
import org.springframework.beans.factory.annotation.Autowired;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Application extends Controller {

    @Autowired
    private TestLogicImpl testLogicImpl;

    public Result index() {
        testLogicImpl.helloLogic();
        System.out.println("INDEX!!!");
        return ok(index.render("Your new application is ready."));
    }

    public static Result getModel() {
        TestModel testModel = new TestModel();
        testModel.name = "ryuta";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        testModel.publish = format.format(date);

        TestParent parent = new TestParent();
        parent.parentName = "test";
        parent.addChild(testModel);
        parent.save();
//
//        testModel.save();

        Logger.info("----------New TestModel ID-----------");
        Logger.info(testModel.id.toString());
        Logger.info(Json.toJson(parent).toString());
        Logger.info(Json.toJson(testModel).toString());
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
