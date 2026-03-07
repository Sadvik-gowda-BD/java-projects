package test;

public class Test2 {


    public static void main(String[] args) {

        int[][] grid = {{0, 0, 1}, {1, 1, 0}, {1, 0, 0}};

        System.out.println(solve(grid));
    }

    private static int solve(int[][] grid) {

        int len = grid.length;

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            int zeroFromRight = 0;
            for (int j = len - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeroFromRight++;
                } else {
                    break;
                }
            }
            arr[i] = zeroFromRight;
        }

        return solve(arr);
    }

    private static int solve(int[] arr) {

        int len = arr.length;
        int swapCount = 0;

        for (int i = 0; i < len; i++) {
            int reqZero = len - (i + 1);

            if (arr[i] < reqZero) {

                int k = -1;
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] >= reqZero) {
                        k = j;
                        break;
                    }
                }

                if (k == -1) return -1;

                for (int j = k; j > i; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapCount++;
                }

            }
        }

        return swapCount;
    }


}


