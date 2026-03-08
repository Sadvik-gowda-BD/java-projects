package com.systemdesign.lld.logger.formatter;

import com.systemdesign.lld.logger.model.LogMessage;

public interface Formatter {
    String format(LogMessage message);
}