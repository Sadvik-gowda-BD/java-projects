package com.it.others;

public class StringVsStringBuffer {
    public static void main(String[] args) {

        String str = "string";
        StringBuffer stringBuffer = new StringBuffer();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str = str + "string";
            //str.concat("string");
        }
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append("string");
        }
        long t4 = System.currentTimeMillis();

        System.out.println("Time by normal string :" + (t2 - t1));
        System.out.println("Time by StringBuffer :" + (t4 - t3));

    }


}
