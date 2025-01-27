package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class GasStation {

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};

//        System.out.println(solve(gas, cost));
//        System.out.println(solve(gas2, cost2));

        System.out.println(solve2(gas, cost));
        System.out.println(solve2(gas2, cost2));

        System.out.println(solve2(gas3, cost3));

    }

    private static int bruteForce(int[] gas, int[] cost) {

        int numOfStation = gas.length;

        for (int k = 0; k < numOfStation; k++) {
            int totalGas = gas[k];
            for (int j = 1; j <= numOfStation; j++) {
                int ind = (k + j) % numOfStation;
                int costInd = ind == 0 ? numOfStation - 1 : ind - 1;
                totalGas -= cost[costInd];
                if (totalGas < 0) {
                    break;
                }
                totalGas += gas[ind];
                if (ind == k) {
                    return k;
                }
            }
        }

        return -1;
    }

    //Optimized code
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }

        return start;
    }

    private static int solve2(int[] gas, int[] cost) {

        int numOfStation = gas.length;
        if (numOfStation == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            }
            return -1;
        }

        int len2 = numOfStation * 2;
        int[] diffArr = new int[numOfStation * 2];

        int startIndex = 0;
        for (int i = 0; i < len2; i++) {
            int ind = i % numOfStation;
            int g = gas[ind];
            int c = cost[ind];


            if (i == 0 || diffArr[i - 1] < 0) {
                diffArr[i] = g - c;
                startIndex = i;
            } else {
                diffArr[i] = diffArr[i - 1] + g - c;
            }
        }

        if (startIndex > numOfStation) {
            return -1;
        } else {
            return startIndex;
        }
    }
}
