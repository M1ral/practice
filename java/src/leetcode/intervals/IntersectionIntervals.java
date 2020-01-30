package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionIntervals {

    public static void main(String[] args) {
        System.out.println("intervalIntersection({{1,3},{5,8},{100,105}}, {{0,10}, {6,12}, {99, 1000}})) = " +
                Arrays.deepToString(intervalIntersection(
                        new int[][]{{1, 3}, {5, 8}, {100, 105}},
                        new int[][]{{0, 10}, {6, 12}, {99, 102}})));
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

        return result.toArray(new int[result.size()][]);
    }
}
