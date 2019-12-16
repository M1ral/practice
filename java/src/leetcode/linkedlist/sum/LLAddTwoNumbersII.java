package leetcode.linkedlist.sum;

import leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/add-two-numbers-ii/
public class LLAddTwoNumbersII {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        Deque<Integer> stackA = new ArrayDeque();
        Deque<Integer> stackB = new ArrayDeque();
        Deque<Integer> stackSum = new ArrayDeque();
        int sum = 0;

        while (null != l1) {
            stackA.push(l1.val);
            l1 = l1.next;
        }

        while (null != l2) {
            stackB.push(l2.val);
            l2 = l2.next;
        }

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            sum  = sum / 10; // carry

            if (!stackA.isEmpty())
                sum += stackA.pop();

            if (!stackB.isEmpty())
                sum += stackB.pop();

            stackSum.push(sum % 10);
        }

        if (sum / 10 == 1)
            stackSum.push(1);

        while (! stackSum.isEmpty()) {
            result.next = new ListNode(stackSum.pop());
            result = result.next;
        }

        return dummy.next;
    }
}
