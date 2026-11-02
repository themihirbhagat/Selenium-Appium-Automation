package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

	private static final Logger log = LogManager.getLogger(LoggerUtil.class);

	private LoggerUtil() {  } // Creating private Constructor because there is no need to initialize this
					// class (Static class)

	// Info Level Logs
	public static void info(String message) {
		log.info(message);
	}

	// Warn Level Logs
	public static void warn(String message) {
		log.warn(message);
	}

	// Error Level Logs
	public static void error(String message) {
		log.error(message);
	}

	// Log Stack trace
	public static void logError(Object printStackTrace) {
		log.error(printStackTrace);
	}

	// Fatal Level Logs
	public static void fatal(String message) {
		log.fatal(message);
	}

	// Debug Level Logs
	public static void debug(String message) {
		log.debug(message);
	}

}
