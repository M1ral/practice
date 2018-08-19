package linkedlist;

import linkedlist.helper.ListNodeHelper;
import linkedlist.pojo.ListNode;

import java.util.Stack;

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

        // merge k sorted linked lists
        n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
        n2 = ListNodeHelper.generateLinkedList(new int[]{2,5,9,10});
        ListNode n3 = ListNodeHelper.generateLinkedList(new int[]{3,8,11,12});
        System.out.println("merge K sorted : " + mergeKSorted(new ListNode[]{n1, n2, n3}));

        // merge 2 sorted linked lists in place
        n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
        n2 = ListNodeHelper.generateLinkedList(new int[]{2,5,9,10});
        System.out.println("merge 2 sorted in place : " + mergeSorted(n1, n2));

        // add 2 numbers, given in reverse (143 = 3->4->1)
        n1 = ListNodeHelper.generateLinkedList(new int[]{9,9});
        n2 = ListNodeHelper.generateLinkedList(new int[]{1});
        System.out.println("add 2 numbers : " + addTwoNumbers(n1, n2));

        // remove nth from last in the list
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        System.out.println("remove nth from last = " + removeNthFromEnd(node, 3));

        // intersection node
        n1 = ListNodeHelper.generateLinkedList(new int[]{1});
        n2 = ListNodeHelper.generateLinkedList(new int[]{1});
        System.out.println("intersection node : " + getIntersectionNode(n1, n2));

    }

    /**
     * Delete node with given value from list
     *
     * @param head
     * @param val
     */
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

    /**
     * Reverse list recursively
     *
     * @param list
     * @return node {@link ListNode}
     */
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

    /**
     * Delete node with given value from list
     *
     * @param head
     * @param n
     */
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

        // initialize head of the result
        ListNode result = null;
        if (n1.val < n2.val) {
            result = new ListNode(n1.val);
            n1 = n1.next;
        } else {
            result = new ListNode(n2.val);
            n2 = n2.next;
        }
        ListNode head = result;

        // merge 2 lists upto equal length of the min length list
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

        // merge n1 if there are elements still remaining
        while (null != n1) {
            result.next = new ListNode(n1.val);
            n1 = n1.next;
            result = result.next;
        }

        // merge n2 if there are elements still remaining
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

    /**
     * Merge given k sorted linked lists
     *
     * @param lists
     * @return
     */
    private static ListNode mergeKSorted(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length < 2) {
            return lists[0];
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeSorted(result, lists[i]);
        }

        return result;
    }

    /**
     * Add given two numbers
     *
     * @param l1
     * @param l2
     * @return sum {@link ListNode}
     */
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

    /**
     * Check if given linked list has a cycle
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (null != fast && null != fast.next && fast.val != slow.val) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (null != fast && null != fast.next && fast.val == slow.val) {
            return true;
        }

        return false;
    }

    /**
     * Remove nth node from last in the list
     *
     * @param head
     * @param n
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n < 0) {
            return null;
        }

        ListNode fast = head;
        int i = 0;
        // increment fast to point to 'nth' node from start
        while (null != fast && i != n) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            if (n == 1) {
                return null;
            } else if (n != i) { // n is greater than the length of the linked list
                return head;
            }
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode result = head;

        while (null != fast) {
            fast = fast.next;
            prev = current;
            current = current.next;
        }

        // delete the node (set prev.next = current.next)
        if (null == prev) { // remove head
            ListNode temp = head.next;
            result = temp;
        } else {
            prev.next = current.next;
        }

        return result;
    }

    /**
     * Get the intersecting node in the 2 lists
     * @param headA
     * @param headB
     *
     * @return intersecting {@link ListNode}
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();

        // push elements from A and B to respective stacks
        while (null != headA) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (null != headB) {
            stackB.push(headB);
            headB = headB.next;
        }

        // pop stacks at the same time and compare values
        // the moment we come across non-matching value, the node after that is the
        // intersection node
        ListNode prev = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode first = stackA.pop();
            ListNode second = stackB.pop();
            if (first.val == second.val) {
                prev = first;
                continue;
            } else {
                break;
            }
        }
        return prev; // last matched node
    }
}
