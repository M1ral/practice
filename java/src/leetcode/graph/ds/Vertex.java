package leetcode.graph.ds;

public class Vertex {

    String label;
    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        return this.label.equals(((Vertex) obj).label);
    }

    @Override
    public int hashCode() {
        return this.label.hashCode();
    }
}
