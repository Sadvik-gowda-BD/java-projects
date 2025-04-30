package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {

    private static int cnt = 0;

    public static void main(String[] args) throws Exception {


    }

    public static void solve() {
        int[] arr = {1, 2, 2, 2, 3, 5, 6};
        int l = 0;
        int r = arr.length;
        int mid = 0;
        int tar = 0;

        while (l < r) {

            mid = (l + r) / 2;

            if (arr[mid] > tar) {
                r = mid - 1;
            } else if (arr[mid] < tar) {
                l = mid + 1;
            }

        }
    }


}
