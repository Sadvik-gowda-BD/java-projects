package com.systemdesign.designpatterns.creational.factory.impl;

import com.systemdesign.designpatterns.creational.factory.OperatingSystem;

public class Ios implements OperatingSystem {
    @Override
    public String getParentCompany() {
        return "Apple";
    }
}
