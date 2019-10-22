package leetcode.linkedlist;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

public class OddEvenList {

    public static void main(String[] args) {
        System.out.println("oddEvenList({1,2,3,4,5}) = " +
                oddEvenList(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 4, 5})));

        System.out.println("oddEvenList2({1,2,3,4,5}) = " +
                oddEvenList2(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 4, 5})));

        System.out.println("oddEvenList({1,2,3}) = " +
                oddEvenList(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3})));

        System.out.println("oddEvenList2({1,2,3}) = " +
                oddEvenList2(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3})));

        System.out.println("oddEvenList({1,2}) = " +
                oddEvenList(ListNodeHelper.generateLinkedList(new int[]{1, 2})));

        System.out.println("oddEvenList2({1,2}) = " +
                oddEvenList2(ListNodeHelper.generateLinkedList(new int[]{1, 2})));

        System.out.println("oddEvenList({1,2}) = " +
                oddEvenList(ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5,6,7,8,9})));

        System.out.println("oddEvenList2({1,2,3,4,5,6,7,8,9}) = " +
                oddEvenList2(ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5,6,7,8,9})));
    }

    /**
     * Join odd positioned nodes to even nodes
     *
     * @param head
     * @return @{@link ListNode}
     */
    public static ListNode oddEvenList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode connect = even;

        while (null != odd && null != even && null != even.next) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = connect;
        return head;
    }

    /**
     * Join odd positioned nodes to even nodes
     *
     * @param head
     * @return ListNode
     */
    public static ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode result = head;
        ListNode currentOdd = head;
        ListNode currentEven = head.next;
        ListNode prevOdd = currentOdd;
        ListNode prevEven = currentEven;
        ListNode couplingNode = currentEven;

        while (null != currentOdd && null != currentOdd.next && null != currentEven && null != currentEven.next) {
            // odd
            currentOdd = currentOdd.next.next;
            prevOdd.next = currentOdd;
            prevOdd = currentOdd;
            // even
            currentEven = currentEven.next.next;
            prevEven.next = currentEven;
            prevEven = currentEven;
        }

        prevOdd.next = couplingNode;
        return result;
    }
}
