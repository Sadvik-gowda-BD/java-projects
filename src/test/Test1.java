package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test1 {


    public static void main(String[] args) {

    }

    private static boolean solve(String s) {

        boolean foundZero = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '0') {
                foundZero = true;
            }

            if (ch == '1' && foundZero) {
                return false;
            }
        }

        return true;
    }


}


