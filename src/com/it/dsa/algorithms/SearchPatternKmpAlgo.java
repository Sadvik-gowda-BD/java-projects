package com.it.dsa.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SearchPatternKmpAlgo {


    public static void main(String[] args) {

        //, pat =
//        System.out.println(solve("abcab", "ab"));
//
//        System.out.println(kmpAlg("abesdu", "edu"));
//        System.out.println(kmpAlg("aabaacaadaabaaba", "aaba"));

//        System.out.println(kmpAlg("abcab", "ab"));
        System.out.println(kmpAlg("geeksforgeeks", "geek"));

    }

    private static List<Integer> bruteForce(String txt, String pat) {

        List<Integer> ls = new ArrayList<>();
        int txtLen = txt.length();
        int ind = 0;

        while (ind < txtLen) {
            System.out.println(ind);

            if (txt.charAt(ind) == pat.charAt(0)) {
                if (check(ind, txt, pat)) {
                    ls.add(ind);
                }
            }
            ind++;

        }
        return ls;
    }

    private static boolean check(int ind, String txt, String pat) {
        int patLen = pat.length();
        int i = 0;

        while (i < patLen) {
            if (i + ind >= txt.length()) {
                return false;
            }
            if (txt.charAt(ind + i) != pat.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }


    public static List<Integer> kmpAlg(String text, String pat) {

        int[] lcs = buildLcs(pat);
        List<Integer> res = new ArrayList<>();

        int textLen = text.length();
        int patLen = pat.length();
        int textInd = 0;
        int patInd = 0;

        while (textInd < textLen) {
            char textChar = text.charAt(textInd);
            char patChar = pat.charAt(patInd);

            if (textChar == patChar) {
                patInd++;
                textInd++;
                if (patInd == patLen) {
                    res.add(textInd - patLen);
                    patInd = lcs[patInd - 1];
                }
            } else if (patInd > 0) {
                patInd = lcs[patInd - 1];
            } else {
                textInd++;
            }
        }
        return res;
    }

    private static int[] buildLcs(String pat) {
        int[] lcs = new int[pat.length()];
        lcs[0] = 0;
        int ind = 1;
        int point = 0;

        while (ind < pat.length()) {
            int indChar = pat.charAt(ind);
            int pointChar = pat.charAt(point);
            if (indChar == pointChar) {
                point++;
                lcs[ind] = point;
            } else {
                point = 0;
            }
            ind++;
        }
        return lcs;
    }

}
