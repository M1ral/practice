package leetcode.graph.traversal;

import java.util.*;

// https://leetcode.com/discuss/interview-question/435160/Oracle-OCI-or-Phone-or-Node-Dependencies

/**
 * Find dependencies of a specific node. Say for example, there is an input stream 2d array in which nodes are given as,
 * [[7,11], [5,11], [3,8], [11,2], [11,9], [8,9],[3,10]]
 * for a given node say 2, the output should be [7,5,11,2] or [5,7,11,2].
 */
public class NodeDependency {
    public static void main(String[] args) {
        int[][] nodes = {{7, 11}, {5, 11}, {3, 8}, {11, 2}, {11, 9}, {8, 9}, {3, 10}};
        System.out.println("Nodes : " + findNodes(nodes, 2));
    }

    public static List<Integer> findNodes(int[][] nodes, int start) {
        if (null == nodes || nodes.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // build graph
        for (int[] n : nodes) {
            map.putIfAbsent(n[1], new HashSet<>());
            map.get(n[1]).add(n[0]);
        }

        System.out.println("map = " +
                Arrays.toString(map.entrySet().toArray()));
        // traverse graph
        bfs(map, new HashSet<Integer>(), start, result);
        Collections.reverse(result);
        return result;
    }

    private static void bfs(Map<Integer, Set<Integer>> map,
                Set<Integer> visited, int start, List<Integer> result) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (! q.isEmpty()) {
            int current = q.remove();
            if (! visited.contains(current)) {
                visited.add(current);
                result.add(current);
                for (int n : map.getOrDefault(current, new HashSet<>())) {
                    if (! visited.contains(n)) {
                        q.add(n);
                    }
                }
            }
        }
    }
}
