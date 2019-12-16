package leetcode.linkedlist.merge;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

    public static void main(String[] args) {
        // merge k sorted linked lists
        ListNode n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
        ListNode n2 = ListNodeHelper.generateLinkedList(new int[]{2,5,9,10});
        ListNode n3 = ListNodeHelper.generateLinkedList(new int[]{3,8,11,12});
        System.out.println("merge K sorted : " + mergeKSorted(new ListNode[]{n1, n2, n3}));
    }
    /**
     * MergeTrees given k sorted linked lists (O(n log k))
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKSorted(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((ListNode l1, ListNode l2) -> l1.val - l2.val);

        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = n;

            if (null != n.next)
                queue.offer(n.next);
        }

        return dummy.next;
    }
}
