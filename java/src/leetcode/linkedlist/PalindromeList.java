package leetcode.linkedlist;

import leetcode.linkedlist.helper.ListNodeHelper;
import leetcode.linkedlist.pojo.ListNode;

import java.util.Stack;

public class PalindromeList {

    public static void main(String[] args) {
        System.out.println("isPalindrome({0, 0}) = " +
                isPalindrome(ListNodeHelper.generateLinkedList(new int[]{0, 0})));

        System.out.println("isPalindrome({1,2,3,2,1}) = " +
                isPalindrome(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 2, 1})));

        System.out.println("isPalindrome({1,2,3,3,2,1}) = " +
                isPalindrome(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 3, 2, 1})));

        System.out.println("isPalindrome({1,2,2,1}) = " +
                isPalindrome(ListNodeHelper.generateLinkedList(new int[]{1, 2, 2, 1})));

        System.out.println("isPalindrome({1, 2, 3, 3, 2, 1}) = " +
                isPalindrome(ListNodeHelper.generateLinkedList(new int[]{1, 2, 3, 3, 2, 1})));
    }
    /**
     * Check if given linked list represents a palindrome number
     * @param head
     * @return boolean
     */
    public static boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack();

        while (null != fast && null != fast.next) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (null != fast) {
            slow = slow.next;
        }

        while (null != slow) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
