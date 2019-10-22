package leetcode.linkedlist;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

public class ReverseInKGroups {

    public static void main(String[] agrs) {
        ListNode head = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5,6,7});
        System.out.println("reverseKGroups(head, 3) = " + reverseKGroups(head, 3));
    }

    public static ListNode reverseKGroups(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode begin = dummy;
        int i = 0;

        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode current = begin.next;
        ListNode next = null;
        ListNode first = current;

        while (current != end) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        begin.next = prev;
        first.next = current;

        return first;
    }
}
