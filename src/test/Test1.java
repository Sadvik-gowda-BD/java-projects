package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Test1 {


    public static void main(String[] args) {

        int n = 0;
        System.out.println(solve(n));

    }

    private static int solve(int n) {
        int noOfBits = Integer.toBinaryString(n).length();
        int allOnes = (1 << noOfBits) - 1;
        int res = n ^ allOnes;
        return res;
    }


}


