package com.it.dsa.algorithms.binarysearch;

import java.util.Arrays;
import java.util.Stack;

//875. Koko Eating Bananas
public class CocoEatingBanana {

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(bruteForce(piles, h));
        System.out.println(bsApproach(piles, h));
    }

    static int bsApproach(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().orElse(0);

        int ans = 0;
        while (low <= high) {

            int mid = low + ((high - low) / 2);
            if (canEat(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans; //or return low
    }


    //TLE
    static int bruteForce(int[] piles, int h) {

        int max = Arrays.stream(piles).max().orElse(-1);

        for (int i = 1; i <= max; i++) {
            if (canEat(piles, h, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean canEat(int[] piles, int h, int k) {

        int timeTaken = 0;

        for (int ind = 0; ind < piles.length; ind++) {
            int val = piles[ind];
            int reqTime;

            if (val % k == 0) {
                reqTime = val / k;
            } else {
                reqTime = (val / k) + 1;
            }
            timeTaken += reqTime;

            if (timeTaken > h) {
                return false;
            }
        }
        return true;
    }

}
