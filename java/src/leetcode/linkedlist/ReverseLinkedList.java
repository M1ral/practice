package leetcode.linkedlist;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    public static void main(String[] args) {
        // reverse
        ListNode node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        System.out.println("reverse(node) = " + reverse(node));

        // reverse
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        System.out.println("reverseInPlace(node) = " + reverseInPlace(node));

        // recursive reverse
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        System.out.println("recursive reverse(node) = " + reverseRecursive(node));
    }

    /**
     * Reverse given linked list
     *
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode prev = head, current = head.next;

        while (null != current) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = null;
        return prev;
    }

    /**
     * Reverse list recursively
     *
     * @param head
     * @return node {@link ListNode}
     */
    private static ListNode reverseRecursive(ListNode head) {
        if (head==null || head.next == null)
            return head;
        ListNode p = reverseRecursive(head.next);
        head.next.next = head; //n+1 th node pointing nth node
        head.next = null;
        return p;
    }

    /**
     * Reverse linked list in place
     * @param head
     * @return @{@link ListNode}
     */
    private static ListNode reverseInPlace(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, c = head;

        while (null != c.next) {
            ListNode pn = p.next;
            p.next = c.next;

            ListNode n = c.next;
            c.next = n.next;

            n.next = pn;
        }
        return dummy.next;
    }
}
