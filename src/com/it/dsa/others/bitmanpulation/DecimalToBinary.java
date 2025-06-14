package com.it.dsa.others.bitmanpulation;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

public class DecimalToBinary {

    public static void main(String[] args) {

        System.out.println(solve(7));

    }

    static String solve(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 2;
            num = num / 2;
            sb.insert(0, rem);
        }

        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }


    //msb is head
    static Data binaryToDecimal1(CustomListNode<Integer> head) {

        if (head.next == null) {
            if (head.val == 1) {
                return new Data(1, 1);
            }
            return new Data(1, 0);
        }
        Data res = binaryToDecimal1(head.next);
        res.mul *= 2;
        res.ans = res.ans + (res.mul * head.val);
        return res;
    }

    private static class Data {
        int mul;
        int ans;

        public Data(int mul, int ans) {
            this.mul = mul;
            this.ans = ans;
        }
    }

    public int binaryToDecimal2(CustomListNode<Integer> head) {
        int sum = 0;

        while (head != null){
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }


}

