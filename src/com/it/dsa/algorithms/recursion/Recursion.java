package com.it.dsa.algorithms.recursion;

import java.util.HashMap;
import java.util.Map;

/*
Best approach to solve Recursion problems:
1)Identity if you can break down problem into smaller problem
2)Write the recursive relation if required
3)Draw the recursive tree
4)About the tree
    1)see the flow of functions, how they are getting into stack
    2)Identify and focus on left tree and right tree calls

5)See how the values are returned at each step

Can any iterative method be replaced by recursion and vice versa?
 */
public class Recursion {

    static Map<Integer, Integer> cacheMap = new HashMap<>();

    public static void main(String[] args) {
        printNNum(5);
        System.out.println("------------------");
        printNNumReverse(5);
    }

    private static void printNNum(int n) {
        if (n == 0) {   //base case
            return;
        }
        printNNum(n - 1);
        System.out.println(n);
    }

    private static void printNNumReverse(int n) {
        System.out.println(n);
        if (n == 1) {   // base case
            return;
        }
        printNNumReverse(n - 1);
    }

    /*
    space complexity: O(n)
     */
    private static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /*
    Tail recursion the recursive call is the last operation performed in the function before returning the result.
    This allows some compilers or JVM optimizations.
    No need to store the previous stack information

    space complexity: O(1)
    TC: O(n)
     */
    // factTailRecursion(5,1);
    private static int factTailRecursion(int n, int ans) {
        if (n == 0 || n == 1) {
            System.out.println("---------- " + ans); //120
            return ans;
        }
        return factTailRecursion(n - 1, n * ans);

    }

    private static int fibonacciByRecursion(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacciByRecursion(num - 1) + fibonacciByRecursion(num - 2);
    }

    private static int fibonacciByRecMemoization(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        if (cacheMap.containsKey(num)) {
            return cacheMap.get(num);
        }
        int result = fibonacciByRecursion(num - 1) + fibonacciByRecursion(num - 2);
        cacheMap.put(num, result);
        return result;
    }

    public static int fibonacciByTailRec(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibonacciByTailRec(n - 1, b, a + b); // Tail-recursive call
    }
}
