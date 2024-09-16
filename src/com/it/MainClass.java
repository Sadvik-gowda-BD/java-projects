package com.it;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass {

    private static MainClass instance = null;
    private static FileReader fileReader;

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("");
        int r = fileReader.read();

        FileWriter fileWriter = new FileWriter("",true);
        fileWriter.write("");
    }

    public static MainClass getInstance() {
        if (null == instance) {
            synchronized (MainClass.class) {
                if (null == instance) {
                    instance = new MainClass();
                }
            }
        }
        return instance;
    }


}
