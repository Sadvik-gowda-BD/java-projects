package com.systemdesign.lld.logger.model;

import java.time.LocalDateTime;

public class LogMessage {

    private LogLevel level;
    private String message;
    private String className;
    private LocalDateTime timestamp;

    public LogMessage(LogLevel level, String message, String className) {
        this.level = level;
        this.message = message;
        this.className = className;
        this.timestamp = LocalDateTime.now();
    }

    public LogLevel getLevel() { return level; }
    public String getMessage() { return message; }
    public String getClassName() { return className; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
