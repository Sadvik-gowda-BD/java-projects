package com.systemdesign.lld.logger.model;

import com.systemdesign.lld.logger.appender.Appender;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private String name;
    private LogLevel level;
    private List<Appender> appenders = new ArrayList<>();

    public Logger(String name, LogLevel level) {
        this.name = name;
        this.level = level;
    }

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    private void log(LogLevel logLevel, String message) {

        if (logLevel.getPriority() < level.getPriority()) {
            return;
        }

        LogMessage logMessage =
                new LogMessage(logLevel, message, name);

        for (Appender appender : appenders) {
            appender.append(logMessage);
        }
    }
}
