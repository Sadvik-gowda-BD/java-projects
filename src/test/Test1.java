package test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        List<Integer> ls = List.of(1, 2, 3);

        List<Integer> temp = new ArrayList<>();
        rec(ls, temp, 0, 2);
//        System.out.println(temp);

    }

    /*

Ex: For array {1, 2, 3} possible size K=2 combination are:
[1, 2], [1, 3], [2, 3]

pair (1,2) != (2,1)

                */
    private static void rec(List<Integer> ls, List<Integer> sub, int ind, int k) {

        if (sub.size() == k) {
            System.out.println(sub);
            return;
        }
        if (ind >= ls.size()) return;

        sub.add(ls.get(ind));
        rec(ls, sub, ind + 1, k);
        sub.removeLast();
        rec(ls, sub, ind + 1, k);

    }


}
