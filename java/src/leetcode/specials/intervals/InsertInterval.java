package leetcode.specials.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println("insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}) = " +
                Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        if (null == intervals || intervals.length == 0 ||
                null == newInterval || newInterval.length == 0) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Step 1 - add all intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);

        // Step 2 - update the newInterval by merging with all overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // add updated interval

        // Step 3 - add remaining intervals
        while (i < intervals.length)
            result.add(intervals[i++]);

        return result.toArray(new int[result.size()][2]);
    }
}
