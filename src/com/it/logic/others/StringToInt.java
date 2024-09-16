package com.it.logic.others;

public class StringToInt {

    public static void main(String[] args) {

        String st = "021230";

        int num =0;

        for(int i=0; i<st.length();i++){
            num = (num*10)+ (st.charAt(i)-'0');
        }

        System.out.println("Integer is "+ num);
    }
}
