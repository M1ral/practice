package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        System.out.println("merge({{1,3},{2,6},{8,10},{15,18}}) = " +
                Arrays.deepToString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }

    public static int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals,
                (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList();
        int[] temp = intervals[0];

        for (int i=1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], current[1]);
            } else {
                result.add(temp);
                temp = current;
            }
        }
        result.add(temp);

        return result.toArray(new int[result.size()][]);
    }
}
