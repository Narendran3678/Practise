package com.logback.LogbackCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.core.*;
public class LogbackCode 
{
	public static Logger logger =LoggerFactory.getLogger(LogbackCode.class);
    public static void main( String[] args )
    {
    	logger.info("Test");
    }
}
