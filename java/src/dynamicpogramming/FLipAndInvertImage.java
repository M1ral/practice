package dynamicpogramming;

import java.util.Arrays;

public class FLipAndInvertImage {

    public static void main(String[] args) {
        System.out.println("Original Image: ");
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        for(int[] arr : A) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("\nFlip and rotate Image: ");
        A = flipAndInvertImage(A);
        for(int[] arr : A) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        if (null == A || A.length == 0) {
            return A;
        }

        int n = A.length;

        // reverse each row
        for (int i = 0; i < n; i++) {
            int length = A[i].length;
            int j = 0;
            for (j = 0; j < n / 2; j++) {
                int temp = A[i][j] == 0 ? 1 : 0;
                A[i][j] = A[i][n-1-j] == 0 ? 1 : 0;
                A[i][n-1-j] = temp;
            }

            if (length % 2 != 0) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }

        return A;
    }
}
