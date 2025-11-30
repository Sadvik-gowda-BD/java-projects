package com.it.others;

public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("returned val is: " + Solve.solve());
    }
}

class Solve {
    public static String solve() {
        try {
            int r = 5/0;
            System.out.println("Inside try");

            return "TRY";
        } catch (ArithmeticException e) {
            return "ARITHMETIC_EXCEPTION";
        } catch (Exception e) {
            return "EXCEPTION";
        } finally {
            System.out.println("Inside finally");
            return "FINALLY";
        }
    }
}
