package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    /**
     * Return the list of average values for each levels of tree
     *
     * @param root
     * @return list
     */
    public List<Double> averageOfLevels(TreeNode root) {
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
}
