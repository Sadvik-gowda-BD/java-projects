package com.it.problem_solve.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//GFG : Next Greater Element in Array
/*
The idea is to use a monotonic decreasing stack (stack that maintains elements in decreasing order). We traverse the array from right to left. For each element, we pop elements from the stack that are smaller than or equal to it, since they cannot be the next greater element. If the stack is not empty, the top of the stack is the next greater element. Finally, we push the current element onto the stack.
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = new int[]{4,3,5};
        System.out.println(Arrays.toString(solve(arr)));
    }

    private static int[] solve(int[] arr) {

        int len = arr.length;
        int[] ans = new int[len];
        ans[len - 1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(arr[len - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {

            int curEle = arr[i];

            while (!st.isEmpty()) {
                int val = st.pop();
                if (val > curEle) {
                    st.push(val);
                    st.push(curEle);
                    ans[i] = val;
                    break;
                }
            }

            if (st.isEmpty()) {
                st.push(curEle);
                ans[i] = -1;
            }
        }
        return ans;
    }

}
