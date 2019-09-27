package specials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intervals {

    public static void main(String[] args) {
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        if (null == A || null == B) {
            return new int[][]{};
        }

        List<int[]> result = new ArrayList();
        int i=0, j=0;

        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);
            if (low <= high) {
                result.add(new int[]{low, high});
            }

            if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] ret = new int[result.size()][2];
        int row = 0;
        for (int[] arr : result) {
            ret[row++] = arr;
        }
        return ret;
    }
}
