package leetcode.linkedlist;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLists {

    public static void main(String[] args) {
        System.out.println("getIntersectionNode({1,2,3,4,5,6}, {9,8,7,4,5,6}) = " + getIntersectionNode(
                ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 4, 5, 6}),
                ListNodeHelper.generateLinkedList(new int[]{9, 8, 7, 4, 5, 6})
        ));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        Deque<ListNode> stackA = new ArrayDeque();
        Deque<ListNode> stackB = new ArrayDeque();
        ListNode result = null;

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        while (! stackA.isEmpty() && !stackB.isEmpty()) {
            if (! stackA.peek().equals(stackB.peek())) {
                break;
            }
            result = stackA.pop();
            stackB.pop();
        }

        return result;
    }
}
