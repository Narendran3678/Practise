package Spring.Boot.Logging.controllers;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexControllers {
    private static final Logger debugLogger = LogManager.getLogger(IndexControllers.class);
    private static final Logger errorLogger = LogManager.getLogger("SYSTEM_ERR");
    @RequestMapping(value={"","/"})
    public String indexMethod() {
        debugLogger.debug("Hello Debug");
        debugLogger.info("Hello Info");
        debugLogger.warn("Hello warn");
        errorLogger.error("Hello Error");
        try {
            int a=1/0;
        }
        catch (Exception e) {
            e.printStackTrace();
            debugLogger.debug("Debug..."+e);
            debugLogger.error("DebugError..."+e);
            errorLogger.error("MyError",e);
        }
        return "Hello";
    }
}
