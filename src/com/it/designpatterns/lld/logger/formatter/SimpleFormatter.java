package com.it.designpatterns.lld.logger.formatter;

import com.it.designpatterns.lld.logger.model.LogMessage;

public class SimpleFormatter implements Formatter {

    @Override
    public String format(LogMessage message) {

        return "[" + message.getLevel() + "] "
                + message.getTimestamp() + " "
                + message.getClassName() + " - "
                + message.getMessage();
    }
}
