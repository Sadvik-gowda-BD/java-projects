package com.it.logic.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RemoveUnbalanceParentheses {

    private static HashMap<Character,Character> hm = new HashMap<>();

    public static void main(String[] args) {
        hm.put('(',')');

        //removeUnbalanceParentheses("((abc)((def))");
        removeUnbalanceParentheses("(a(b)))(c(d)"); //(a(b))(cd)
    }

    private static void removeUnbalanceParentheses(String str){
        Stack<Character> st = new Stack<>();
        List<Character> removeCh = new ArrayList<>();
        for (int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                st.push('(');
            }else if(ch == ')'){
                if(st.isEmpty()){
                    removeCh.add(ch);
                }else {
                    st.pop();
                }

            }
        }

        System.out.println(removeCh);
        System.out.println(st);

    }


}
