package com.it.problem_solve.others;

public class CountOfContinousChar {

    public static void main(String[] args) {

        print("aaabbcccaab");
    }

    //Input – aaabbcccaab
    //Output – a3b2c3a2b1
    private static void print(String st){

        char preChar = st.charAt(0);
        int count = 1;
        String newStr = "";
        for(int i=1; i<st.length();i++){
            char currentChar=st.charAt(i);
            if(currentChar == preChar){
                count++;
            }else {
                newStr += preChar+String.valueOf(count);
                count = 1;
                preChar = currentChar;
            }
        }
        newStr += preChar+String.valueOf(count);


        System.out.println(newStr);
    }
}
