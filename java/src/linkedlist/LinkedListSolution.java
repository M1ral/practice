package linkedlist;

import linkedlist.helper.ListNodeHelper;
import linkedlist.pojo.ListNode;

public class LinkedListSolution {

    public static void main(String[] args) {

        // delete
        ListNode node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        deleteFromList(node, 3);
        System.out.println("delete node from list : " + node);

        // reverse
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        reverse(node);
        System.out.println("reverse(node) = " + node);

    }

    private static void deleteFromList(ListNode head, int val) {
        if (null == head) {
            return;
        }
        if (head.val == val) {
            ListNode temp = head.next;
            head = null;
            return;
        }

        ListNode p = head;
        ListNode c = head;

        while (null != c && c.val != val) {
            p = c;
            c = c.next;
        }

        if (null != c) {
            p.next = c.next;
        }
    }

    /**
     * Reverse given linked list
     *
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (null != current) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }
}
