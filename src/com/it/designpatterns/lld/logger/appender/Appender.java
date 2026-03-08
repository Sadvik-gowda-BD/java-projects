package com.it.designpatterns.lld.logger.appender;

import com.it.designpatterns.lld.logger.model.LogMessage;

public interface Appender {

    void append(LogMessage message);
}
