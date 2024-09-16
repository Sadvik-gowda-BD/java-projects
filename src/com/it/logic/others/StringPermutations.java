package com.it.logic.others;

public class StringPermutations {

    public static void main(String[] args) {

        String st = "abc";
        generatePermutations(st,"");
    }

    public static void generatePermutations(String st, String result){

        if(st.length()==0){
            System.out.println(result);
            return;
        }
        for(int i=0; i<st.length();i++){
            char currentChar = st.charAt(i);

            String remainingString = st.substring(0, i) + st.substring(i + 1);

            // Recur for the remaining string
            generatePermutations(remainingString, result + currentChar);
        }
    }
}
