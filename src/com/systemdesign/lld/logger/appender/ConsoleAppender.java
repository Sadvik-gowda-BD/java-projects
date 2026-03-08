package com.systemdesign.lld.logger.appender;

import com.systemdesign.lld.logger.formatter.Formatter;
import com.systemdesign.lld.logger.model.LogMessage;

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