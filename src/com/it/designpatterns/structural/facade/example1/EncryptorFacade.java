package com.it.designpatterns.structural.facade.example1;

import java.util.Objects;

public class EncryptorFacade {
    public String encrypt(String type, String text) {
        String hash = "";
        if (Objects.equals(type, "MD5")) {
            MD5Encryptor e = new MD5Encryptor();
            hash = e.encrypt(text);
        } else if (Objects.equals(type, "SHA")) {
            SHA e = new SHA();
            hash = e.encrypt(text);
        } else if ("SHA256".equals(type)) {
            SHA256 e = new SHA256();
            hash = e.encrypt(text);
        }
        return hash;
    }
}
