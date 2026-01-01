package com.it.dsa.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsack {

    public static void main(String[] args) {

        int thresholdWt = 15;

        List<Obj> ls = new ArrayList<>();
        ls.add(new Obj(10, 2));
        ls.add(new Obj(5, 3));
        ls.add(new Obj(15, 5));
        ls.add(new Obj(7, 7));
        ls.add(new Obj(6, 1));
        ls.add(new Obj(18, 4));
        ls.add(new Obj(3, 1));

        //sol1(ls, thresholdWt);
        sol2(ls, thresholdWt);
    }

    private static void sol2(List<Obj> ls, int thresholdWt) {

        ls.sort((o1, o2) -> {
            if ((o2.profit / (float) o2.weight) > (o1.profit / (float) o1.weight)) {
                return 1;
            }
            return -1;
        });

        int totalWeight = 0;
        float tp = 0;

        for (Obj ob : ls) {

            if (totalWeight == thresholdWt) {
                break;
            }
            int rem = thresholdWt - totalWeight;

            if (ob.weight <= rem) {
                totalWeight += ob.weight;
                tp += ob.profit;
            } else {
                float perKg = ob.profit / (float) ob.weight;
                tp += (perKg * rem);
                totalWeight += rem;
            }
        }
        System.out.println("Profit: " + tp);

    }

    private static void sol1(List<Obj> ls, int thresholdWt) {

        ls.sort((o1, o2) -> {
            if ((o2.profit / (float) o2.weight) > (o1.profit / (float) o1.weight)) {
                return 1;
            }
            return -1;
        });

        int w = 0;
        int p = 0;

        for (Obj ob : ls) {
            int newWeight = w + ob.weight;

            if (newWeight == thresholdWt) {
                p += ob.profit;
                break;
            } else if (newWeight < thresholdWt) {
                p += ob.profit;
                w = newWeight;
            }
        }

        System.out.println("Profit: " + p);
    }

    private static class Obj {
        int profit;
        int weight;

        public Obj(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }
}
