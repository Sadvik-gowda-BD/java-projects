package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

//825. Friends Of Appropriate Ages
public class FriendOfAppAge {

    public static void main(String[] args) {

        int[] ip = {20, 30, 100, 110, 120};
        System.out.println(solve2(ip));
    }

    /*
    y>0.5 * age[x] + 7
    y<=X
    x>=100 || y<=100 // It is redundant, not require to check Y is always less than 100 (0.5 * 120 + 7 =67)
     */
    public static int solve2(int[] ages) {
        int len = ages.length;
        Arrays.sort(ages);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int xAge = ages[i];
            //Y age boundary
            int left = getIndex(ages, (xAge / 2) + 7);
            int right = getIndex(ages, xAge);

            ans += Math.max(right - left - 1, 0);
        }

        return ans;
    }

    private static int getIndex(int[] ages, int target) {
        int right = ages.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (ages[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    //Solution 3
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];  // Frequency array for ages 1 to 120
        int totalRequests = 0;

        // Count how many people are of each age
        for (int age : ages) {
            ageCount[age]++;
        }

        // Iterate over possible sender ages (ageA)
        for (int ageA = 15; ageA <= 120; ageA++) {
            if (ageCount[ageA] == 0) continue;  // Skip if no one is this age

            // For each ageA, determine valid recipients ageB
            for (int ageB = 15; ageB <= 120; ageB++) {
                if (ageCount[ageB] == 0) continue;  // Skip if no one is this age

                // Check if ageB is a valid recipient of a friend request from ageA
                if (ageB > 0.5 * ageA + 7 && ageB <= ageA) {
                    totalRequests += ageCount[ageA] * ageCount[ageB];

                    // If ageA == ageB, subtract self-friend requests
                    if (ageA == ageB) {
                        totalRequests -= ageCount[ageA];
                    }
                }
            }
        }

        return totalRequests;
    }

    public int solve(int[] ages) {
        int len = ages.length;
        int ans = 0;

        boolean[][] cannot = new boolean[len][len];
        Arrays.sort(ages);

        for (int x = 0; x < len; x++) {
            for (int y = x; y < len; y++) {
                if (x == y) continue;
                if (ages[y] > ages[x]) break;
                if (ages[y] > 100 && ages[x] < 100) continue;
                if (ages[y] <= getXage(ages[x])) continue;

                ans++;
            }
        }

        return ans;
    }

    private static float getXage(int age) {
        return (float) (0.5 * age + 7);
    }
}
