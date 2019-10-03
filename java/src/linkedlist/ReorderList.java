package linkedlist;

import linkedlist.pojo.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        //ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n5;

        System.out.println("n1 = " + n1);
        // Reorder list
        reorderList(n1);

        System.out.println("n1 = " + n1);
    }

    public static void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }

        ListNode slow = head, fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverse(second);

        ListNode p1 = head;
        ListNode p2 = second;

        while (null != p2) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next = p2;
            p2.next = t1;

            p1 = t1;
            p2 = t2;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode p = head;
        ListNode c = head.next;

        while (null != c) {
            ListNode temp = c.next;
            c.next = p;
            p = c;
            c = temp;
        }

        head.next = null;
        return p;
    }
}
