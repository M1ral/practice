package leetcode.tree;

import java.util.*;

public class LinkedListAtLevels {
    public static void main(String[] args) {
        TreeNode root = Tree.createDummyTree();
        // recursively
        System.out.println("RECURSIVELY");
        printLists(getLinkedListAtEachDepth(root));
        // iteratively
        System.out.println("ITERATIVELY");
        printLists(getLinkedListAtEachDepthIteratively(root));
    }

    /**
     * Return the list of LinkedList for each level of the leetcoce.tree
     * @param root
     * @return list of LinkedLists
     */
    public static List<LinkedList> getLinkedListAtEachDepth(TreeNode root) {
        List<LinkedList> lists = new ArrayList<>();

        if (null == root) {
            return lists;
        }

        createLeveledList(root, lists, 0);
        return lists;
     }

    /**
     * Recursively construct leetcoce.linkedlist for each level of the leetcoce.tree
     *
     * @param treeNode
     * @param lists
     * @param level
     */
     private static void createLeveledList(TreeNode treeNode, List<LinkedList> lists, int level) {
        if (null == treeNode) {
            return;
        }

        if (lists.size() == level) {
            lists.add(level, new LinkedList());
        }
        LinkedList<Integer> list = lists.get(level);
        list.add(treeNode.val);

        createLeveledList(treeNode.left, lists, level + 1);
        createLeveledList(treeNode.right, lists, level + 1);
     }

    /**
     * Iteratively construct and return list of LinkedLists for each level of the leetcoce.tree
     * @param root
     * @return list of LinkedLists
     */
     private static List<LinkedList> getLinkedListAtEachDepthIteratively(TreeNode root) {
        List<LinkedList> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }

        TreeNode current = root;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            while (size != 0) {
                current = queue.remove();
                list.add(current.val);

                if (null != current.left) {
                    ((LinkedList<TreeNode>) queue).add(current.left);
                }
                if (null != current.right) {
                    ((LinkedList<TreeNode>) queue).add(current.right);
                }
                size--;
            }

            lists.add(level, list);
            level++; // next level
        }

        return lists;
     }

    // print list of LinkedList items
    public static void printLists(List<LinkedList> lists) {
        if (null == lists || lists.isEmpty()) {
            System.out.println("EMPTY LIST!");
        }

        for (LinkedList list : lists) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + "->");
            }
            System.out.print(".");
            System.out.println();
        }
    }
}