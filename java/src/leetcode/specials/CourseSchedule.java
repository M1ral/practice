package leetcode.specials;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int n, int[][] pre) {
        if (null == pre || pre.length == 0) {
            return true;
        }
        if (n < 1) {
            return false;
        }

        int[] counter = new int[n];
        for (int i = 0; i < pre.length; i++) {
            counter[pre[i][0]]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (counter[i] == 0) {
                q.offer(i);
            }
        }
        int numPre = q.size();

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < pre.length; i++) {
                if (pre[i][1] == current) {
                    counter[pre[i][0]]--;
                    if (counter[pre[i][0]] == 0) {
                        q.offer(pre[i][0]);
                        numPre++;
                    }
                }
            }
        }

        return n == numPre;
    }

    public int[] findOrder(int n, int[][] pre) {
        if (null == pre) {
            return new int[]{};
        }
        if (n < 0) {
            return new int[]{};
        }

        int[] counter = new int[n];
        int[] ans = new int[n];
        int j = 0;
        for (int i=0; i < pre.length; i++) {
            counter[pre[i][0]]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i=0; i < n; i++) {
            if (counter[i] == 0) {
                q.offer(i);
            }
        }

        int numPre = q.size();

        while (!q.isEmpty()) {
            int current = q.poll();
            ans[j++] = current;

            for (int i=0; i < pre.length; i++) {
                if (pre[i][1] == current) {
                    counter[pre[i][0]]--;
                    if (counter[pre[i][0]] == 0) {
                        numPre++;
                        q.offer(pre[i][0]);
                    }
                }
            }
        }

        if (numPre != n) {
            return new int[]{};
        }

        return ans;
    }
}
