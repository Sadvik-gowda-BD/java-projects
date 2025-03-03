package com.it.designpatterns.creational.factory.impl;

import com.it.designpatterns.creational.factory.OperatingSystem;

public class Android implements OperatingSystem {
    @Override
    public String getParentCompany() {
        return "Google";
    }
}
