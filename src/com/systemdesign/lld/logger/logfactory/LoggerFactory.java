package com.systemdesign.lld.logger.logfactory;

import com.systemdesign.lld.logger.appender.Appender;
import com.systemdesign.lld.logger.appender.ConsoleAppender;
import com.systemdesign.lld.logger.appender.FileAppender;
import com.systemdesign.lld.logger.formatter.Formatter;
import com.systemdesign.lld.logger.formatter.JsonFormatter;
import com.systemdesign.lld.logger.formatter.SimpleFormatter;
import com.systemdesign.lld.logger.model.LogLevel;
import com.systemdesign.lld.logger.model.Logger;

import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {

    private static final LoggerFactory INSTANCE = new LoggerFactory();

    private final Map<String, Logger> loggerMap = new HashMap<>();

    private LoggerFactory() {}

    public static LoggerFactory getInstance() {
        return INSTANCE;
    }

    public Logger getSimpleLogger(Class<?> clazz) {

        String className = clazz.getSimpleName();

        if (loggerMap.containsKey(className)) {
            return loggerMap.get(className);
        }

        Logger logger = new Logger(className, LogLevel.DEBUG);

        Formatter formatter = new SimpleFormatter();
        Appender consoleAppender = new ConsoleAppender(formatter);

        logger.addAppender(consoleAppender);

        loggerMap.put(className, logger);

        return logger;
    }

    public Logger getFileLogger(Class<?> clazz) {

        String className = clazz.getSimpleName();

        if (loggerMap.containsKey(className)) {
            return loggerMap.get(className);
        }

        Logger logger = new Logger(className, LogLevel.DEBUG);

        Formatter formatter = new JsonFormatter();
        Appender fileAppender = new FileAppender("logs.txt", formatter);

        logger.addAppender(fileAppender);

        loggerMap.put(className, logger);

        return logger;
    }
}