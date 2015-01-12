import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.Logger;

/**
 * Created by ryuta on 15/01/12.
 */
public class Global extends GlobalSettings {

    private  ApplicationContext context;

    @Override
    public void onStart(Application app) {
        System.out.println("on Start");
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        System.out.println("GETCONTROLLERINSTANCE");
        return context.getBean(controllerClass);
    }
}
