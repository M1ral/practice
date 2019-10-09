package leetcoce.linkedlist;

import leetcoce.linkedlist.helper.ListNodeHelper;
import leetcoce.linkedlist.pojo.ListNode;

public class ReverseBetween {

    public static void main(String[] args) {
        System.out.println("reverseBetween2(n, 2, 4) = " +
                reverseBetween2(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 4, 5}), 1, 4));
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        int k = 1;
        while (cur.next != null && k != m) {
            cur = cur.next;
            pre = pre.next;
            k++;
        }

        while (cur.next != null && k != n) {
            ListNode preNext = pre.next;
            pre.next = cur.next;
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preNext;
            k++;
        }

        return dummy.next;
    }
}
