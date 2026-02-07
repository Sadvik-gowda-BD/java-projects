package com.it.problem_solve.leetcode.others;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthHighest {

    public static void main(String[] args) {
        int[] array = {4, 1, 7, 3, 9, 8, 5};
        int k = 3;
        System.out.println(logicByPriorityQueue(array, k));
    }

    /*
        Time complexity: O(nlogk)
        Space complexity: O(k)
     */
    public static int logicByPriorityQueue(int[] array, int k) {
        // Create a min-heap with a size of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); //Collections.reverseOrder() for kth lowest

        // Iterate over the array
        for (int num : array) {
            // Add elements to the min-heap
            minHeap.add(num);

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // The root of the min-heap is the kth highest element
        return minHeap.peek();
    }

    /*  logic by sorting
        Time complexity: O(nlogn)
        Space complexity: O(sort)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
