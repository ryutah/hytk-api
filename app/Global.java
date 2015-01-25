import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * アプリケーション起動時の初期設定などを行う
 * クラス名をGlobalにすることで、PlayFrameworkから自動的に呼ばれる
 * ようになる。
 *
 * Created by ryuta on 15/01/12.
 */
public class Global extends GlobalSettings {

    private  ApplicationContext context;

    /**
     * アプリケーション起動時、最初に呼び出される。
     * SpringのApplicationContextインスタンスを生成。
     * @param app
     */
    @Override
    public void onStart(Application app) {
        System.out.println("on Start");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * ApplicationContextから取得したインスタンスを返す。
     * routesがコントローラインスタンスを生成する際に呼び出される。
     *
     * @param controllerClass
     * @param <A>
     * @return
     * @throws Exception
     */
    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        System.out.println("GETCONTROLLERINSTANCE");
        return context.getBean(controllerClass);
    }

    @Override
    public Action onRequest(Http.Request request, Method method) {
        Logger.info("+++++++++++++++++ IN on Request ++++++++++++++++++");
        Logger.info("----------------Request-------------------");
        Logger.info("URI : " + request.uri());
        Logger.info("UserName : " + request.username());
        Logger.info("RemoteAddress : " + request.remoteAddress());
        Logger.info("Host : " + request.host());
        Logger.info("Method : " + request.method());
        Logger.info("Path : " + request.path());
        Logger.info("Version : " + request.version());
        Logger.info("Headers : ");
        request.headers().forEach(new BiConsumer<String, String[]>() {
            @Override
            public void accept(String v, String[] strings) {
                Arrays.stream(strings).forEach(s -> Logger.info(v + ":" + s));
            }
        });
        Logger.info("--------------Method---------------");
        Logger.info("Name : " + method.getName());
        Logger.info("GenericString : " + method.toGenericString());
        Logger.info("toString : " + method.toString());

        return super.onRequest(request, method);
    }

    @Override
    public F.Promise<Result> onError(Http.RequestHeader requestHeader, Throwable throwable) {
        Logger.error("["+ throwable.getClass().toString() + "]:" + throwable.getStackTrace());

        return super.onError(requestHeader, throwable);
    }
}
