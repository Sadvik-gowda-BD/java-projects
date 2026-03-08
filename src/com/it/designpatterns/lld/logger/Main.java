package com.it.designpatterns.lld.logger;

import com.it.designpatterns.lld.logger.logfactory.LoggerFactory;
import com.it.designpatterns.lld.logger.model.Logger;

public class Main {

    public static void main(String[] args) {

        //Singleton pattern. Here only one LoggerFactory object, one simpleLogger and one FileLogger object will
        // create.
        Logger logger = LoggerFactory.getInstance().getSimpleLogger(Main.class);

        logger.info("Application started");
        logger.debug("Debug message");
        logger.info("INFO log");
    }
}

