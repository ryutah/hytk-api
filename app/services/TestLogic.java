package services;

import org.springframework.stereotype.Service;
import play.Logger;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class TestLogic{

    public void helloLogic() {
        Logger.info("*****************************************");
        Logger.info("IN TEST LOGIG!");
        Logger.info("*****************************************");

    }
}
