package com.framework.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static final Logger logger = LogManager.getLogger();
    private static final boolean CONSOLE_LOGGING_ENABLED = true; // Toggle console logging here

    private LoggerUtility() {
        // Prevent instantiation
    }

    private static String formatMessage(String level, String message) {
        return String.format("[%s] %s", level, message);
    }

    private static void logToConsole(String level, String message) {
        if (CONSOLE_LOGGING_ENABLED) {
            System.out.println(formatMessage(level, message));
        }
    }

    public static void info(String message) {
        String formattedMessage = formatMessage("INFO", message);
        logger.info(formattedMessage);
        logToConsole("INFO", message);
    }

    public static void warn(String message) {
        String formattedMessage = formatMessage("WARN", message);
        logger.warn(formattedMessage);
        logToConsole("WARN", message);
    }

    public static void error(String message, Throwable throwable) {
        String formattedMessage = formatMessage("ERROR", message);
        logger.error(formattedMessage, throwable);
        logToConsole("ERROR", message);
    }

    public static void debug(String message) {
        String formattedMessage = formatMessage("DEBUG", message);
        logger.debug(formattedMessage);
        logToConsole("DEBUG", message);
    }

    public static void logWithClassContext(Class<?> clazz, String level, String message) {
        String contextMessage = String.format("[%s] %s: %s", level, clazz.getSimpleName(), message);
        switch (level) {
            case "INFO":
                logger.info(contextMessage);
                break;
            case "WARN":
                logger.warn(contextMessage);
                break;
            case "ERROR":
                logger.error(contextMessage);
                break;
            case "DEBUG":
                logger.debug(contextMessage);
                break;
            default:
                logger.info(contextMessage);
        }
        logToConsole(level, clazz.getSimpleName() + ": " + message);
    }
}
