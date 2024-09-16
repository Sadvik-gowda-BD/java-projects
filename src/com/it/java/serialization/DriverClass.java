package com.it.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DriverClass {

    private static String filePath = "D:\\repo\\java-projects\\src\\files\\Temp-file3.txt";

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        TestSerializable testSerializable = new TestSerializable(102, "Virat K", "pass");

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            ObjectOutputStream objectOpStream = new ObjectOutputStream(fileOut);

            objectOpStream.writeObject(testSerializable);
            System.out.println("Serialized data is saved");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void read() {
        try (FileInputStream filein = new FileInputStream(filePath)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(filein);
            TestSerializable test = (TestSerializable) objectInputStream.readObject();
            System.out.println("Deserialized Person: " + test);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
