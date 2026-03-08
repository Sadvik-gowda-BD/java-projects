package com.it.designpatterns.lld.logger.formatter;

import com.it.designpatterns.lld.logger.model.LogMessage;

public interface Formatter {
    String format(LogMessage message);
}