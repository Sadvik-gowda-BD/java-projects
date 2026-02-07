package test;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test1 {

    int x = 1;

    public static void main(String[] args) {

        int[] res = solve(new int[]{-10});

        System.out.println(Arrays.toString(res));
    }

    //0 1 2 3 4  len=5
    private static int[] solve(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else if (nums[i] > 0) {
                int rem = (nums[i] + i) % len;
                res[i] = nums[rem];
            } else {
                int val = Math.abs(nums[i]);
                if (val <= i) {
                    res[i] = nums[i-val];
                } else {
                    int rem = (val - i) % len;
                    if(rem ==0 ){
                        res[i] = nums[rem];
                    }else {
                        res[i] = nums[len - rem];
                    }

                }
            }
        }
        return res;
    }


}
