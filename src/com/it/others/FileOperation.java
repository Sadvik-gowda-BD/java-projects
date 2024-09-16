package com.it.others;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

    private static final String sourceFile = "D:\\repo\\java-projects\\src\\files\\Temp-file1.txt";
    private static final String destFile = "D:\\repo\\java-projects\\src\\files\\Temp-file2.txt";

    public static void main(String[] args) throws IOException {
        String file1Data = getFileData();
        addDataToFIle(file1Data);
    }

    private static String getFileData() {
        int ch;
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileReader = new FileReader(sourceFile);) {
            while ((ch = fileReader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            System.out.println("Data in source file:\n" + stringBuilder.toString());
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //close the file if not using the try with resource
            //fileReader.close
        }
    }

    private static void addDataToFIle(String data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(destFile, true)) {
            fileWriter.write(data);
        }
    }
}
