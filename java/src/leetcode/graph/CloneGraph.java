package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {

    }

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (null == node) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        map.put(clone.val, clone);

        for (Node neighbor : clone.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }

        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
