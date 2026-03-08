package com.systemdesign.lld.logger.appender;

import com.systemdesign.lld.logger.model.LogMessage;

public interface Appender {

    void append(LogMessage message);
}
