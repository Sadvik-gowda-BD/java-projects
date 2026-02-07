package com.it.problem_solve.leetcode.others;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//390. Elimination Game
public class EliminationGame {

    public static void main(String[] args) {

        int n = 1;
        solveByBruteforce(n);

        System.out.println();
    }

    public static int solveByBruteforce(int n) {
        LinkedList<Integer> ls1 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            ls1.add(i);
        }

        LinkedList<Integer> ls2 = new LinkedList<>();
        boolean leftToRight = true;


        while (ls1.size() > 1 || ls2.size() > 1) {
//            System.out.println("ls1:" + ls1);
//            System.out.println("ls2:" + ls2);

            if (leftToRight) {
                for (int i = 1; i < ls1.size(); i = i + 2) {
                    ls2.add(ls1.get(i));
                }
                ls1.clear();
            } else {
                for (int i = ls2.size() - 2; i >= 0; i = i - 2) {
                    ls1.addFirst(ls2.get(i));
                }
                ls2.clear();
            }
            leftToRight = !leftToRight;
        }

//        System.out.println("ls1:" + ls1);
//        System.out.println("ls2:" + ls2);

        if (ls1.isEmpty()) {
            return ls2.get(0);
        } else {
            return ls1.get(0);
        }
    }
}
