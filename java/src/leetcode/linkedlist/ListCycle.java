package leetcode.linkedlist;

import leetcode.linkedlist.pojo.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
public class ListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode slow = head, fast = head.next;

        while (null != fast && null != fast.next &&
                slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (null == fast || null == fast.next)
                ? false
                : slow.val == fast.val;
    }
}
