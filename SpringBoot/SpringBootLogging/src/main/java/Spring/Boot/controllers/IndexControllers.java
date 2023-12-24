package Spring.Boot.controllers;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexControllers {
    private static final Logger serverLog = LogManager.getLogger(IndexControllers.class);
    private static final Logger systemLog = LogManager.getLogger("SYSTEM_ERR");
    @RequestMapping(value={"","/"})
    public String indexMethod() {
        return "Hello";
    }


}
