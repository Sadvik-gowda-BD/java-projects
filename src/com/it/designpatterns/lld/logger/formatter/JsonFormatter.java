package com.it.designpatterns.lld.logger.formatter;

import com.it.designpatterns.lld.logger.model.LogMessage;

public class JsonFormatter implements Formatter {

    @Override
    public String format(LogMessage message) {

        return "{"
                + "\"level\":\"" + message.getLevel() + "\","
                + "\"time\":\"" + message.getTimestamp() + "\","
                + "\"class\":\"" + message.getClassName() + "\","
                + "\"message\":\"" + message.getMessage() + "\""
                + "}";
    }
}
