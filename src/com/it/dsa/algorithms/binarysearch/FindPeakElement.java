package com.it.dsa.algorithms.binarysearch;


//162. Find Peak Element
public class FindPeakElement {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};
        System.out.println(solve2(arr));
    }


    public static int solve(int[] nums) {
        int r = nums.length - 1;
        int l = 0;
        int mid;

        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int solve2(int[] nums) {
        int len = nums.length;

        if (len == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[len - 1] > nums[len - 2]) return len - 1;

        int r = nums.length - 2;
        int l = 1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
