package com.it.designpatterns.lld.logger.logfactory;

import com.it.designpatterns.lld.logger.appender.Appender;
import com.it.designpatterns.lld.logger.appender.ConsoleAppender;
import com.it.designpatterns.lld.logger.appender.FileAppender;
import com.it.designpatterns.lld.logger.formatter.Formatter;
import com.it.designpatterns.lld.logger.formatter.JsonFormatter;
import com.it.designpatterns.lld.logger.formatter.SimpleFormatter;
import com.it.designpatterns.lld.logger.model.LogLevel;
import com.it.designpatterns.lld.logger.model.Logger;

public class LoggerFactory {

    private static LoggerFactory instance;

    private LoggerFactory() {}

    public static LoggerFactory getInstance() {

        if (instance == null) {
            instance = new LoggerFactory();
        }

        return instance;
    }

    // Simple logger (console + simple formatter)
    public Logger getSimpleLogger(Class<?> clazz) {

        Logger logger =
                new Logger(clazz.getSimpleName(), LogLevel.DEBUG);

        Formatter formatter = new SimpleFormatter();

        Appender consoleAppender =
                new ConsoleAppender(formatter);

        logger.addAppender(consoleAppender);

        return logger;
    }

    // File logger (file + json formatter)
    public Logger getFileLogger(Class<?> clazz) {

        Logger logger =
                new Logger(clazz.getSimpleName(), LogLevel.DEBUG);

        Formatter formatter = new JsonFormatter();

        Appender fileAppender =
                new FileAppender("logs.txt", formatter);

        logger.addAppender(fileAppender);

        return logger;
    }
}