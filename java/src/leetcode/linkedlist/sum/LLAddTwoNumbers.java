package leetcode.linkedlist.sum;

import leetcode.linkedlist.pojo.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class LLAddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1 || null == l2) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
        }

        if (sum / 10 == 1)
            head.next = new ListNode(1);

        return dummy.next;
    }
}
