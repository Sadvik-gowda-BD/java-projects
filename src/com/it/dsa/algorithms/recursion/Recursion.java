package com.it.dsa.algorithms.recursion;

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

    public static void main(String[] args) {
        printNNum(5);
        System.out.println("------------------");
        printNNumReverse(5);
    }

    private static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
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
}
