package linkedlist;

import linkedlist.pojo.ListNode;

public class RemoveNthFromList {

    public static ListNode removeNthFromList(ListNode head, int n) {
        if (null == head || n < 0) return head;
        if (n == 0) return head.next;

        ListNode fast = head;
        while (n != 0 && null != fast) {
            fast = fast.next;
            n--;
        }

        if (n != 0) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;

        while (null != fast) {
            fast = fast.next;
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        return head;
    }
}
