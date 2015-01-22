package services.impl;

import org.springframework.stereotype.Service;
import play.Logger;

/**
 * Created by ryuta on 15/01/12.
 */

@Service
public class TestLogicImpl {

    public void helloLogic() {
        Logger.info("*****************************************");
        Logger.info("IN TEST LOGIG!");
        Logger.info("*****************************************");

    }
}
