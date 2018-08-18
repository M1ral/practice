package linkedlist;

import linkedlist.helper.ListNodeHelper;
import linkedlist.pojo.ListNode;

public class LinkedListSolution {

    public static void main(String[] args) {

        // delete 1
        ListNode node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        deleteFromList(node, 1);
        System.out.println("delete node from list : " + node);

        // delete 2
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        delete(node, 1);
        System.out.println("delete node from list 2 : " + node);

        // reverse
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        reverse(node);
        System.out.println("reverse(node) = " + node);

        // recursive reverse
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        reverseRecursive(node);
        System.out.println("recursive reverse(node) = " + node);

        // merge 2 sorted linked lists
        ListNode n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
        ListNode n2 = ListNodeHelper.generateLinkedList(new int[]{2,5,9,10});
        System.out.println("merge 2 sorted : " + mergeSorted(n1, n2));

        // merge 2 sorted linked lists in place
        n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
        n2 = ListNodeHelper.generateLinkedList(new int[]{2,5,9,10});
        System.out.println("merge 2 sorted in place : " + mergeSorted(n1, n2));

        // add 2 numbers, given in reverse (143 = 3->4->1)
        n1 = ListNodeHelper.generateLinkedList(new int[]{9,9});
        n2 = ListNodeHelper.generateLinkedList(new int[]{1});
        System.out.println("add 2 numbers : " + addTwoNumbers(n1, n2));
    }

    private static void deleteFromList(ListNode head, int val) {
        if (null == head) {
            return;
        }
        if (head.val == val) {
            ListNode temp = head.next;
            head = null;
            return;
        }

        ListNode p = head;
        ListNode c = head;

        while (null != c && c.val != val) {
            p = c;
            c = c.next;
        }

        if (null != c) {
            p.next = c.next;
        }
    }

    /**
     * Reverse given linked list
     *
     * @param head
     */
    private static ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (null != current) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    private static ListNode reverseRecursive(ListNode list) {
        if (list == null) return null; // first question

        if (list.next == null) return list; // second question

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        ListNode secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        ListNode reverseRest = reverseRecursive(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }

    private static void delete(ListNode head, int n) {
        if (null == head) {
            return;
        }

        ListNode current = head;
        if (n == current.val) {
            head = current.next;
            return;
        }


        ListNode prev = null;

        while (null != current && current.val != n) {
            prev = current;
            current = current.next;
        }

        if (null != current && current.val == n) {
            prev.next = current.next;
        }
    }

    /**
     * Merge two sorted linked lists
     *
     * @param n1
     * @param n2
     * @return merged {@link ListNode}
     */
    private static ListNode mergeSorted(ListNode n1, ListNode n2) {
        if (null == n1 && null == n2) {
            return null;
        }
        if (null == n1) {
            return n2;
        }
        if (null == n2) {
            return n1;
        }

        // initilize head of the result
        ListNode result = null;
        if (n1.val < n2.val) {
            result = new ListNode(n1.val);
            n1 = n1.next;
        } else {
            result = new ListNode(n2.val);
            n2 = n2.next;
        }
        ListNode head = result;

        while (null != n1 && null != n2) {
            if (n1.val < n2.val) {
                result.next = new ListNode(n1.val);
                n1 = n1.next;
            } else {
                result.next = new ListNode(n2.val);
                n2 = n2.next;
            }
            result = result.next;
        }

        while (null != n1) {
            result.next = new ListNode(n1.val);
            n1 = n1.next;
            result = result.next;
        }

        while (null != n2) {
            result.next = new ListNode(n2.val);
            n2 = n2.next;
            result = result.next;
        }

        return head;
    }

    /**
     * Merge 2 sorted linkedlists in place
     *
     * @param n1
     * @param n2
     * @return merged {@link ListNode}
     */
    private static ListNode mergeSortedInPlace(ListNode n1, ListNode n2) {
        if (null == n1 && null == n2) {
            return null;
        }
        if (null == n1) {
            return n2;
        }
        if (null == n2) {
            return n1;
        }

        ListNode result = null;
        if (n1.val < n2.val) {
            result = n1;
            n1 = n1.next;
        } else {
            result = n2;
            n2 = n2.next;
        }

        while (null != n1 && null != n2) {
            if (n1.val < n2.val) {
                result.next = n1;
                n1 = n1.next;
            } else {
                result.next = n2;
                n2 = n2.next;
            }
            result = result.next;
        }

        while (null != n1) {
            result.next = new ListNode(n1.val);
            n1 = n1.next;
            result = result.next;
        }

        while (null != n2) {
            result.next = new ListNode(n2.val);
            n2 = n2.next;
            result = result.next;
        }

        return result;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        int sum = 0;
        int carry = 0;
        ListNode current = null;
        ListNode head = null;

        while (null != l1 && null != l2) { // l1 = 1-2, l2=1-2 (21 + 21) = 42 -> 24

            sum = l1.val + l2.val + carry; // sum = sum + previous carry
            carry = 0; // reset carry after adding to sum
            l1 = l1.next;
            l2 = l2.next;

            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }

            if (null == current) { // first time only - initialize head
                current = new ListNode(sum);
                head = current;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
        }

        ListNode n = null;
        if (null != l1) {
            n = l1;
        } else if (null != l2) {
            n = l2;
        }

        // remaining digits of l1/l2
        while (null != n) {
            sum = n.val + carry;
            carry = 0;

            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }

            current.next = new ListNode(sum);
            current = current.next;
            n = n.next;
        }

        // if both numbers were of same length and we have carry left over
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // reverse the list before returning
        //return reverse(head);
        return head;
    }
}
