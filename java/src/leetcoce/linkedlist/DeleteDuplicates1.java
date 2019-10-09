package leetcoce.linkedlist;

import leetcoce.linkedlist.helper.ListNodeHelper;
import leetcoce.linkedlist.pojo.ListNode;

public class DeleteDuplicates1 {

    public static void main(String[] args) {
        System.out.println("deleteDuplicates() = " +
                deleteDuplicates(ListNodeHelper.generateLinkedList(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8})));

        System.out.println("deleteDuplicates2() = " +
                deleteDuplicates2(ListNodeHelper.generateLinkedList(new int[]{1, 1, 1, 2, 3})));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode current = head;
        while (null != current && null != current.next) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(head.val == 0 ? 1 : 0);
        dummy.next = head;

        ListNode p = dummy;
        ListNode c = head;

        while (null != c) {
            while (null != c.next && c.val == c.next.val) {
                c = c.next;
            }

            if (p.next == c) {
                p = p.next;
            } else {
                p.next = c.next;
            }

            c = c.next;
        }

        return dummy.next;
    }
}
