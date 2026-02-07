package com.it.problem_solve.leetcode.others;

//50. Pow(x, n)
public class Pow {

    public static void main(String[] args) {


        double x = 2.1;
        int n = 3;

        double x2 = 2;
        int n2 = -200000000;


//        System.out.println(solve(x, n));
//        System.out.println(solve(x2, n2));

        System.out.println(solveOptimize(x2,n2));


    }

    public static double solveOptimize(double x, int n) {
        double posAns = solveRecOpt(x, Math.abs(n));
        if (n < 0) {
            return 1 / posAns;
        }
        return posAns;
    }

    public static double solveRecOpt(double x, int n) {
        if (n == 0 || x==1) return 1;

        if (n % 2 == 0) {
            return solveRecOpt(x * x, n / 2);
        } else {
            return x * solveRecOpt(x * x, n / 2);
        }
    }

    public static double solve(double x, int n) {
        double posAns = solveRec(x, Math.abs(n));
        if (n < 0) {
            return 1 / posAns;
        }
        return posAns;
    }

    public static double solveRec(double x, int n) {
        if (n == 0) return 1;

        return x * solveRec(x, n - 1);
    }

}
