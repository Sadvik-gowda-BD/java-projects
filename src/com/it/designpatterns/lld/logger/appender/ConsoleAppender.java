package com.it.designpatterns.lld.logger.appender;

import com.it.designpatterns.lld.logger.formatter.Formatter;
import com.it.designpatterns.lld.logger.model.LogMessage;

public class ConsoleAppender implements Appender {

    private Formatter formatter;

    public ConsoleAppender(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {

        String formatted = formatter.format(message);

        System.out.println(formatted);
    }
}