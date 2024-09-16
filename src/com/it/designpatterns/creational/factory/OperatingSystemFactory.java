package com.it.designpatterns.creational.factory;

import com.it.designpatterns.creational.factory.impl.Android;
import com.it.designpatterns.creational.factory.impl.Ios;
import com.it.designpatterns.creational.factory.impl.Windows;

public class OperatingSystemFactory {

    public OperatingSystem getOperatingSystem(String osType) {
        if ("windows".equalsIgnoreCase(osType)) {
            return new Windows();
        } else if ("ios".equalsIgnoreCase(osType)) {
            return new Ios();
        } else if ("android".equalsIgnoreCase(osType)) {
            return new Android();
        } else {
            return null;
        }
    }
}
