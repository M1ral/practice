package leetcode.graph.ds;

public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = Graph.getDummy();
        System.out.println("graph = " + graph);

        // dfs
        System.out.println("dfs(graph, \"Bob\") = " + GraphUtils.dfs(graph, "Bob"));

        //  bfs
        System.out.println("dfs(graph, \"Bob\") = " + GraphUtils.bfs(graph, "Bob"));
    }
}
