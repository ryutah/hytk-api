import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.Logger;

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
}
