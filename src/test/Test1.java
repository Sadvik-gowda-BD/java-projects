package test;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {


        int[] arr = new int[]{10,5, 2, 1, -7,6, 8, 3, -2};

        int[] res = sort(arr);
        System.out.println(Arrays.toString(res));
    }


    public static int[] sort(int[] arr) {

        if (arr.length <= 1) return arr;

        int l = 0, r = arr.length - 1;
        int mid = (r - l) / 2;
        int[] lArr = new int[mid - l + 1];
        int[] rArr = new int[r - mid];

        for (int i = 0; i <= mid; i++) {
            lArr[i] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            rArr[i - mid - 1] = arr[i];
        }

        int[] sortedLArr = sort(lArr);
        int[] sortedRArr = sort(rArr);
        return merge(sortedLArr, sortedRArr);
    }

    public static int[] merge(int[] arr1, int[] arr2) {

        int l1 = 0, r1 = 0, i = 0;

        int[] newArr = new int[arr1.length + arr2.length];

        while (l1 < arr1.length && r1 < arr2.length) {

            if (arr1[l1] < arr2[r1]) {
                newArr[i] = arr1[l1];
                l1++;
            } else {
                newArr[i] = arr2[r1];
                r1++;
            }
            i++;
        }

        while (l1 < arr1.length) {
            newArr[i] = arr1[l1];
            l1++;
            i++;
        }

        while (r1 < arr2.length) {
            newArr[i] = arr2[r1];
            r1++;
            i++;
        }

        return newArr;
    }
}
