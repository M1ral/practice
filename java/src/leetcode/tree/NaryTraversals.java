package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTraversals {

    // recursive
    public void preorderRec(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }

        // add to list first - pre order
        list.add(root.val);
        for (Node n : root.children) {
            preorderRec(n, list);
        }
    }

    // iterative
    public List<Integer> preorderIter(Node root) {
        List<Integer> list = new ArrayList();
        if (null == root) {
            return list;
        }

        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(current.val);

            for (int i = current.children.size()-1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return list;
    }

    // recursive
    public void postorderRec(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }
        for (Node n : root.children) {
            postorderRec(n, list);
        }
        // add to list later - post order
        list.add(root.val);
    }

    // iterative
    public List<Integer> postorderIter(Node root) {
        List<Integer> list = new ArrayList();
        if (null == root) {
            return list;
        }

        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(current.val);

            for (Node n : current.children) {
                stack.push(n);
            }
        }
        Collections.reverse(list);
        return list;
    }
}

class Node {
    public int val;
    public List<Node>  children;
}
