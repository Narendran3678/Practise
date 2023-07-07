package com.logback.LogbackCode;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.*;

public class GenLogger {
	public static LoggerContext loggerContext=null;
	public static void logMessage(String message,String priority,String logFileName,Class<?> className)
	{
		loggerContext=(LoggerContext) LoggerFactory.getILoggerFactory();
		FileAppender fileAppender = new FileAppender();
	    fileAppender.setContext(loggerContext);
	    fileAppender.setName("timestamp");
	    fileAppender.setFile(logFileName+".log");
	    
	    PatternLayout layout=new PatternLayout();
	    layout.setPattern("%d %C %M %m %n");
	    
	    
	    
	}
}
