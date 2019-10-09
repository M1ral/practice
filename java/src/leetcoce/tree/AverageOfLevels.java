package leetcoce.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
637. Average of Levels in Binary Tree

Given a non-empty binary leetcoce.tree, return the average value of the nodes on each level in the form of an leetcoce.array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
*/

public class AverageOfLevels {

    public static void main(String[] args) {
        System.out.println("---------- ITERATIVE -----------");
        List<Double> avg = averageOfLevels(Tree.createDummyTree());
        avg.forEach(System.out::println);

        System.out.println("---------- RECURSIVE -----------");
        avg = averageOfLevelsIter(Tree.createDummyTree());
        avg.forEach(System.out::println);
    }

    /**
     * Return the list of average values for each levels of leetcoce.tree
     *
     * @param root
     * @return list
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList();
        if (null == root) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0.0;
            int count = size;

            while (size != 0) {
                TreeNode current = q.remove();
                sum += current.val;
                if (null != current.left) {
                    q.add(current.left);
                }
                if (null != current.right) {
                    q.add(current.right);
                }
                size--;
                if (size == 0) {
                    // calculate the average and add it to the list
                    double avg = sum / count;
                    list.add(avg);
                }
            }
        }
        return list;
    }

    /**
     * Return the list of avg values per each level of the leetcoce.tree
     *
     * @param root
     * @return List
     */
    public static List<Double> averageOfLevelsIter(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        List<LevelData> data = new ArrayList<>();
        traverse(root, data, 0);

        for (int i = 0; i < data.size(); i++) {
            result.add(i, data.get(i).sum / data.get(i).numElements);
        }

        return result;
    }

    /**
     * Recursively traverse the leetcoce.tree and populate the List of LevelData that has
     * sum of elements per level and total number of elements for each level
     *
     * @param root
     * @param data
     * @param level
     */
    public static void traverse(TreeNode root, List<LevelData> data, int level) {
        if (null == root) {
            return;
        }

        if (level == data.size()) {
            data.add(level, new LevelData());
        }
        data.get(level).sum += root.val;
        data.get(level).numElements++;

        traverse(root.left, data, level + 1);
        traverse(root.right, data, level + 1);
    }
}

/**
 * Helper class to maintain Sum of values and number of elements per level
 */
class LevelData {
    public int level;
    public int numElements;
    public double sum;
}
