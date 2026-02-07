package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArray {

    public static void main(String[] args) {


        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] res = solve(nums1, nums2);

        System.out.println(Arrays.toString(res));

    }

    private static int[] easySoln(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private static int[] solve(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int len1 = arr1.length;
        int len2 = arr2.length;

        int p1 = 0;
        int p2 = 0;

        while (p1 < len1 && p2 < len2) {

            if (arr1[p1] == arr2[p2]) {
                set.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] res = new int[set.size()];

        Iterator<Integer> itr = set.iterator();

        int ind = 0;
        while (itr.hasNext()) {
            res[ind] = itr.next();
            ind++;
        }

        return res;
    }
}
