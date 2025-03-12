package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InsertInterval {

    public static void main(String[] args) {

        int[][] arr1 = {{1, 3}, {6, 9}};
        int[] intr1 = {2, 5};

        int[][] res = solve(arr1, intr1);

        PrintArray.printArray(res);
    }

/*

       Clean, optimized anf less number of line
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }


 */


    public static int[][] solve(int[][] arr, int[] newInter) {
        LinkedList<int[]> list = new LinkedList<>();

        boolean hasMerged = false;
        if (arr.length == 0) {
            list.add(newInter);
            hasMerged = true;
        } else {
            if (newInter[1] < arr[0][0]) {
                list.add(newInter);
                hasMerged = true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] curr = arr[i];
            if (newInter[0] <= curr[1] && !hasMerged) {
                if (newInter[1] < curr[0]) {
                    list.add(newInter);
                    list.add(curr);
                    hasMerged = true;
                    continue;
                }
                hasMerged = true;
                curr[0] = Math.min(curr[0], newInter[0]);
                curr[1] = Math.max(curr[1], newInter[1]);
                int lastEnd = curr[1];
                int j;
                for (j = i + 1; j < arr.length; j++) {
                    int[] next = arr[j];
                    if (lastEnd >= next[0]) {
                        lastEnd = Math.max(next[1], lastEnd);
                    } else {
                        break;
                    }
                }
                curr[1] = lastEnd;
                i = j - 1;
                list.add(curr);
            } else {
                list.add(curr);
            }
        }

        if (!hasMerged) {
            list.add(newInter);
        }

        return list.toArray(new int[list.size()][]);
    }


    /*
    Easy solution
    add first, sort then merge
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        Collections.sort(intervalList, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervalList.get(0);

        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);

            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                res.add(current);
                current = interval;
            }
        }

        res.add(current);
        return res.toArray(new int[res.size()][]);
    }



}
