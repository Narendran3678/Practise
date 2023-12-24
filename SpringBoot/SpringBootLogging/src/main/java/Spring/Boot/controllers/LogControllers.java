package Spring.Boot.controllers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
public class LogControllers {
    private static final Logger serverLog = LogManager.getLogger(IndexControllers.class);
    private static final Logger systemLog = LogManager.getLogger("SYSTEM_ERR");
    @RequestMapping(value={"/serverlog"})
    public String serverLogMethod() {
        serverLog.trace("Trace Log Printed");
        serverLog.debug("Debug Log Printed");
        serverLog.info("Info Log Printed");
        serverLog.warn("Warn Log Printed");
        serverLog.error("Error Log Printed");
        try {
            int a = 1/0;
        }
        catch(Exception e)
        {
            serverLog.error("Exception Log Printed ->",e);
        }
        return "Hello";
    }
    @RequestMapping("/systemlog")
    public String systemLogMethod() {
        systemLog.trace("Trace Log Printed");
        systemLog.debug("Debug Log Printed");
        systemLog.info("Info Log Printed");
        systemLog.warn("Warn Log Printed");
        systemLog.error("Error Log Printed");
        try {
            int a = 1/0;
        }
        catch(Exception e)
        {
            systemLog.error("Exception Log Printed ->",e);
        }
        return "Hello";
    }
}
