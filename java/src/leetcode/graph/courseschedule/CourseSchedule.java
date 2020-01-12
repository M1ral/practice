package leetcode.graph.courseschedule;

import java.util.*;

// https://leetcode.com/problems/course-schedule
// explanation - https://www.youtube.com/watch?v=dis_c84ejhQ
public class CourseSchedule {

    public static void main(String[] args) {
        // Course schedule 1
        System.out.println("canFinish(2, {{0, 1}}) = " + canFinish(2, new int[][]{{0, 1}}));
        System.out.println("canFinish(2, {{0, 1}}) = " + canFinish2(2, new int[][]{{0, 1}}));
        System.out.println("canFinish(2, {{1, 0}}) = " + canFinish(2, new int[][]{{1, 0}}));
        System.out.println("canFinish(2, {{0, 1},{1, 0}}) = " + canFinish(2, new int[][]{{0, 1}, {1, 0}}));

        // Course schedule 2
        System.out.println("findOrder(2, {{0, 1}}) = " + Arrays.toString(findOrder(2, new int[][]{{0, 1}})));
        System.out.println("findOrder2(2, {{1, 0}}) = " + Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }

    public static boolean canFinish(int n, int[][] pre) {
        if (null == pre || pre.length == 0) return true;
        if (n < 1) return false;

        int[] inDegree = new int[n];
        for (int[] pair : pre) {
            inDegree[pair[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        int course = 0;
        for (int i : inDegree) {
            // identify courses which has zero indegree
            // i.e., they don't have any dependencies
            if (i == 0) q.add(course);
            course++;
        }

        int numPre = q.size();
        // start taking courses
        while (!q.isEmpty()) {
            int current = q.remove();
            for (int[] pair : pre) {
                if (pair[1] == current) {
                    inDegree[pair[0]]--; // take the course
                    if (inDegree[pair[0]] == 0) {
                        q.offer(pair[0]);
                        numPre++;
                    }
                }
            }
        }
        return n == numPre;
    }

    public static int[] findOrder(int n, int[][] pre) {
        if (null == pre || pre.length == 0 || n < 1) {
            return new int[]{};
        }

        int[] inDegree = new int[n], ans = new int[n];
        for (int[] pair : pre) {
            inDegree[pair[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        int course = 0;
        for (int i : inDegree) {
            if (i == 0) q.add(course);
            course++;
        }

        // start taking courses
        int index = 0, numPre = q.size();
        while (!q.isEmpty()) {
            int current = q.poll();
            ans[index++] = current;

            for (int[] pair : pre) {
                if (current == pair[1]) {
                    inDegree[pair[0]]--; // take course
                    if (inDegree[pair[0]] == 0)  {
                        q.offer(pair[0]);
                        numPre++;
                    }
                }
            }
        }

        if (n != numPre)
            return new int[]{};

        return ans;
    }

    public static boolean canFinish2(int n, int[][] pre) {
        if (null == pre || pre.length == 0) return true;
        if (n < 1) return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : pre) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int course : map.keySet()) {
            if (map.getOrDefault(course, new HashSet()).isEmpty()) {
                q.add(course); // course that doesn't have dependency
            }
        }

        int numPre = q.size();
        while (! q.isEmpty()) {
            int current = q.remove();
            for (int[] pair : pre) {
                if (pair[1] == current) {
                    map.get(pair[0]).remove(pair[1]);
                    if (map.get(pair[0]).isEmpty()) {
                        q.add(pair[0]);
                        numPre++;
                    }
                }
            }

        }

        return n == numPre;
    }
}
