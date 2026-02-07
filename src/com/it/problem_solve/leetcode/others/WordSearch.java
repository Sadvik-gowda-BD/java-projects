package com.it.problem_solve.leetcode.others;

//79. Word Search
public class WordSearch {

    public static void main(String[] args) {


        char[][] arr = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String st = "ABCCED";

        System.out.println(solve(arr, st));

    }

    public static boolean solve(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = solve(board, word, i, j, 0);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean solve(char[][] board, String word, int i, int j, int ind) {
        if (!isValidCord(board, i, j) || (board[i][j] != word.charAt(ind))) { // it check for visit condition as well board[i][j] == '*'
            return false;
        }

        if (ind == word.length() - 1) return true;

        char temp = word.charAt(ind);
        board[i][j] = '*';
        boolean top = solve(board, word, i - 1, j, ind + 1);
        boolean bottom = solve(board, word, i + 1, j, ind + 1);
        boolean left = solve(board, word, i, j - 1, ind + 1);
        boolean right = solve(board, word, i, j + 1, ind + 1);

        if (top || bottom || left || right) {
            return true;
        }

        board[i][j] = temp;
        return false;
    }

    private static boolean isValidCord(char[][] arr, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length;
    }

}
