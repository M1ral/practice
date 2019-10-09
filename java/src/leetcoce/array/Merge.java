package leetcoce.array;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSorted(new int[]{1,2,3,7,8}, new int[]{0,4,5,9})));
    }

    public static int[] mergeSorted(int[] A, int[] B) {
        if ((null == A || A.length == 0) && (null == B || B.length == 0)) {
            return null;
        }

        if (null == A || A.length == 0) {
            return B;
        }

        if (null == B || B.length == 0) {
            return A;
        }

        int i = A.length - 1;
        int j = B.length - 1;
        int len = A.length + B.length;
        int k = len - 1;
        int[] result = new int[len];

        while (i > 0 && j > 0) {
            if (A[i] > B[j]) {
                result[k] = A[i];
                i--;
            } else if (A[i] < B[j]) {
                result[k] = B[j];
                j--;
            }
            k--;
        }

        while (i >= 0) {
            result[k] = A[i];
            i--;
            k--;
        }

        while (j >= 0) {
            result[k] = B[j];
            j--;
            k--;
        }

        return result;
    }
}
