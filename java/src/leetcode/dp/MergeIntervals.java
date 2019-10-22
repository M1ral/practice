package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        int k = 0;
        for (Interval interval : intervals) {
            starts[k] = interval.start;
            ends[k] = interval.end;
            k++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < n; i++) {
            if (i == n-1 || starts[i+1] > ends[i]) {
                result.add(new Interval(starts[j], ends[i]));
                j = i+1;
            }
        }

        return result;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
