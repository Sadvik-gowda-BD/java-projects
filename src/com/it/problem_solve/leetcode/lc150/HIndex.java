package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;
import java.util.Collections;

/*

274. H-Index

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith
paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given
researcher has published at least h papers that have each been cited at least h times.

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000

 */
public class HIndex {

    public static void main(String[] args) {

        int[] c1 = {6, 5, 3, 0, 1};
        int[] c2 = {100};
        int[] c3 = {4, 4, 4, 4, 4, 4};

        System.out.println(solve(c1));
        System.out.println(solve(c2));
        System.out.println(solve(c3));


    }

    //[3,0,6,1,5] = > [6,5,3,0,1]
    public static int solve(int[] citations) {

        int len = citations.length;
        Arrays.sort(citations);

        int hInd = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] > hInd) {
                hInd = len - i;
            } else {
                return hInd;
            }
        }

        return hInd;
    }
}
