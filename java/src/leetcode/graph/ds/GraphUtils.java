package leetcode.graph.ds;

import java.util.*;

public class GraphUtils {

    public static Set<String> dfs(Graph graph, String root) {
        if (null == graph || null == root || root.isEmpty()) {
            return Collections.emptySet();
        }

        Set<String> visited = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            String vertex = stack.removeLast();
            if (! visited.contains(vertex)) {
                visited.add(vertex);
                graph.getAdjVertices(vertex).forEach(v -> {
                    stack.add(v.label);
                });
            }
        }

        return visited;
    }

    public static Set<String> bfs(Graph graph, String root) {
        if (null == graph || null == root || root.isEmpty()) {
            return Collections.emptySet();
        }

        Set<String> visited = new LinkedHashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(root);
        visited.add(root);

        while (! q.isEmpty()) {
            String vertex = q.remove();
            graph.getAdjVertices(vertex).forEach(v -> {
                if (! visited.contains(v.label)) {
                    visited.add(v.label);
                    q.add(v.label);
                }
            });
        }

        return visited;
    }
}
