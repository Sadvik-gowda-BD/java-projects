package com.it.others;

public class StringVsStringBuffer {
    public static void main(String[] args) {

        String str = "string";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

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

        long t5 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("string");
        }
        long t6 = System.currentTimeMillis();

        System.out.println("Time by normal string :" + (t2 - t1));
        System.out.println("Time by StringBuffer :" + (t4 - t3));
        System.out.println("Time by stringBuilder :" + (t6 - t5));


    }


}
