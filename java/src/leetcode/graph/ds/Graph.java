package leetcode.graph.ds;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjListMap;

    public Graph() {
        this.adjListMap = new HashMap<>();
    }

    public void addVertex(String label) {
        this.adjListMap.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex toRemove = new Vertex(label);
        this.adjListMap.values().forEach(e -> {e.remove(toRemove);});
        this.adjListMap.remove(toRemove);
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1), v2 = new Vertex(label2);
        adjListMap.get(v1).add(v2);
        adjListMap.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1), v2 = new Vertex(label2);
        List<Vertex> eV1 = adjListMap.get(v1);
        List<Vertex> eV2 = adjListMap.get(v2);
        if (null != eV1) eV1.remove(v2);
        if (null != eV2) eV2.remove(v1);
    }

    public List<Vertex> getAdjVertices(String label) {
        return this.adjListMap.get(new Vertex(label));
    }

    @Override
    public String toString() {
        if (this.adjListMap.isEmpty()) return "empty graph!";
        StringBuilder sb = new StringBuilder("\n");
        adjListMap.keySet().forEach(v -> {
            sb.append(v.label + " : ");
            adjListMap.get(v).forEach(adjVertex -> {
                sb.append(adjVertex.label).append(" ");});
            sb.append("\n");
        });

        return sb.toString();
    }

    public static Graph getDummy() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}
