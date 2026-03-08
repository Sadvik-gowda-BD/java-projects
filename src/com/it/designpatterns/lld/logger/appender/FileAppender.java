package com.it.designpatterns.lld.logger.appender;

import com.it.designpatterns.lld.logger.formatter.Formatter;
import com.it.designpatterns.lld.logger.model.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender {

    private String filePath;
    private Formatter formatter;

    public FileAppender(String filePath, Formatter formatter) {
        this.filePath = filePath;
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {

        String formatted = formatter.format(message);

        try (FileWriter writer = new FileWriter(filePath, true)) {

            writer.write(formatted + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}