package Spring.Boot.Logging.controllers;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexControllers {
    private static final Logger logger = LogManager.getLogger(IndexControllers.class);
    @RequestMapping(value={"","/"})
    public String indexMethod() {
        logger.debug("Hello Debug");
        logger.info("Hello Info");
        logger.warn("Hello warn");
        logger.error("Hello error");
        return "Hello";
    }
}
