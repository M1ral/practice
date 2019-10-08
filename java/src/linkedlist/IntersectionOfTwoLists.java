package linkedlist;

import linkedlist.helper.ListNodeHelper;
import linkedlist.pojo.ListNode;

import java.util.Stack;

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

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (null != headA) {
            stackA.push(headA);
            headA = headA.next;
        }

        while (null != headB) {
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode p = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode first = stackA.pop();
            ListNode second = stackB.pop();

            if (first == second) {
                p = first;
                continue;
            } else {
                break;
            }
        }

        return p;
    }
}
