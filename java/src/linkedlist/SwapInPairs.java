package linkedlist;

import linkedlist.helper.ListNodeHelper;
import linkedlist.pojo.ListNode;

public class SwapInPairs {

    public static void main(String[] args) {
        System.out.println("swapPairs(ListNodeHelper.generateLinkedList(1,2,3,4)) = " + swapPairs(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 4})));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
