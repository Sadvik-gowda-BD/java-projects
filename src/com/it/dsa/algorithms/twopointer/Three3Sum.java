package com.it.dsa.algorithms.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Three3Sum {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        System.out.println(threeSum(arr));

    }

    private static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;

        for (int p1 = 0; p1 < len; p1++) {
            if (p1 != 0 && arr[p1] == arr[p1 - 1]) {
                continue;
            }
            int p3 = len - 1;
            int p2 = p1 + 1;

            while (p2 < p3) {
                int sum = arr[p1] + arr[p2] + arr[p3];
                if (sum == 0) {
                    ls.add(List.of(arr[p1], arr[p2], arr[p3]));
                    p3--;
                    while (p2 < p3 && arr[p3] == arr[p3 + 1]) {
                        p3--;
                    }
                } else if (sum > 0) {
                    p3--;
                }else {
                    p2++;

                }

            }


        }

        return ls;
    }

}
