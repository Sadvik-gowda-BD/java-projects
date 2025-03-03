package com.it.dsa.others.bitmanpulation;

public class Swap {

    public static void main(String[] args) {
        swap();

    }

    private static void swap() {
        int a = 3;
        int b = 5;

        StringBuilder before = new StringBuilder("Before swap a: ");
        before.append(a).append(" b:").append(b);
        System.out.println(before);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        StringBuilder after = new StringBuilder("After swap a: ");
        after.append(a).append(" b:").append(b);
        System.out.println(after);
    }

}
