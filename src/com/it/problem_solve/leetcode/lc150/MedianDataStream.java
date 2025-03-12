package com.it.problem_solve.leetcode.lc150;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianDataStream {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianDataStream() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }


    public static void main(String[] args) {

        MedianDataStream ms = new MedianDataStream();
        ms.addNum(1);
        ms.addNum(2);
        ms.addNum(4);
        ms.addNum(5);

        System.out.println(ms.left);
        System.out.println(ms.right);
        System.out.println(ms.findMedian());


    }


    public void addNum(int num) {
        int leftSize = left.size();
        int rightSize = right.size();

        if (leftSize == rightSize) {
            if (leftSize == 0) {
                left.add(num);
            } else {
                Integer le = left.peek();
                if (num < le) {
                    left.add(num);
                } else {
                    right.add(num);
                }
            }

        } else if (leftSize < rightSize) {
            Integer re = right.peek();
            if (re < num) {
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
        } else {
            Integer le = left.peek();
            if (le > num) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
        }

    }


    public double findMedian() {
        int leftSize = left.size();
        int rightSize = right.size();

        if (leftSize == 0 && rightSize == 0) return 0;

        if (leftSize == rightSize) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            if (leftSize > rightSize) {
                return left.peek();
            }
            return right.peek();
        }
    }


    /*
   Simple solution
    */
    public boolean even = true;

    public double findMedian2() {
        // there are even elements, pick two elements from each half
        if (even)
            return (left.peek() + right.peek()) / 2.0;
            // there are odd elements, pick one from the smaller half
        else
            return left.peek();
    }

    public void addNum2(int num) {
        // we have even elements in total, now for the next element we need to push it into the smaller half
        // because the smaller half will have 1 more element than that in the larger half
        // we put the element into the larger half first
        // "filter" the data and find the smallest one (this is a min heap), this one should be in the smaller half
        if (even) {
            right.offer(num);
            left.offer(right.poll());
            // we have odd elements in total, now for the next element, we need to push it into the larger half to maintain balance, so that both heaps will have k/2 elements
            // we put the element into the smaller half first
            // "filter" the data and get the largest one (this is a max heap), this one should be in the larger half
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
        // notice that even is set to be true at first, since there are 0 element, and we will go to the first "if" condition
        even = !even;
    }
}
