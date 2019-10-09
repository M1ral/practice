package leetcoce.linkedlist;

import leetcoce.linkedlist.helper.ListNodeHelper;
import leetcoce.linkedlist.pojo.ListNode;

import java.util.Date;
import java.util.Stack;

public class LinkedListSolution {

    private static long START;
    private static long END;

    public static void main(String[] args) {

        // delete 1
        ListNode node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        deleteFromList(node, 1);
        System.out.println("delete node from list : " + node);

        // delete 2
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        delete(node, 1);
        System.out.println("delete node from list 2 : " + node);

        // rec reverse try dev
        START = new Date().getTime();
        ListNode n1 = ListNodeHelper.generateLinkedList(new int[]{1,2,3});
        System.out.println("rec rev list : " + recRev(n1));
        END = new Date().getTime();
        System.out.println("rec rev time : " + (END - START));

        // merge 2 sorted linked lists
        n1 = ListNodeHelper.generateLinkedList(new int[]{1,4,7});
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

        // remove nth from last in the list
        node = ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5});
        System.out.println("remove nth from last = " + removeNthFromEnd(node, 3));

        // intersection node
        n1 = ListNodeHelper.generateLinkedList(new int[]{1});
        n2 = ListNodeHelper.generateLinkedList(new int[]{1});
        System.out.println("intersection node : " + getIntersectionNode(n1, n2));

        // swap 2 leetcoce.linkedlist nodes without swapping val
        n1 = ListNodeHelper.generateLinkedList(new int[]{2});
        n2 = ListNodeHelper.generateLinkedList(new int[]{9});
        ListNode n3 = ListNodeHelper.generateLinkedList(new int[]{2,1,4,5,3,7,8,9});
        System.out.println("swap nodes = " + swap(n3, n1, n2));

        // check palindrome
        n1 = ListNodeHelper.generateLinkedList(new int[]{2,4,5,3,4,2});
        System.out.println("check palindrome : " + isPalindrome(n1));

        n1 = ListNodeHelper.generateLinkedList(new int[]{1,2,3,2,1});
        System.out.println("check palindrome : " + isPalindrome(n1));
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
            ListNode temp = head;
            head = head.next;
            temp = null;
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
     * MergeTrees two sorted linked lists
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
     * MergeTrees 2 sorted linkedlists in place
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

        return (null != fast && null != fast.next && fast.val == slow.val);
    }

    /**
     * Remove nth node from last in the list
     *
     * @param head
     * @param n
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return head;
        }

        ListNode fast = head;
        while (fast != null && n != 0) {
            fast = fast.next;
            n--;
        }

        if (null == fast && n != 0) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while (null != fast) {
            fast = fast.next;
            prev = current;
            current = current.next;
        }

        if (null == prev) {
            // remove head
            ListNode temp = head.next;
            return temp;
        } else {
            prev.next = current.next;
        }

        return head;
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

    /**
     * Swap given 2 nodes WITHOUT swapping val in the source list
     *
     * @param head
     * @param a
     * @param b
     */
    private static ListNode swap(ListNode head, ListNode a, ListNode b) {
        if (null == a || null == b) {
            return null;
        }
        if (a.val == b.val) {
            return null;
        }
        // return when...
        // a is not present
        // b is not present
        // a and b are same

        // continue when...
        // a is the first node
        // a is the last node
        // b is the first node
        // b is the last node

        ListNode result = head;
        ListNode current = head;
        ListNode currentA = head;
        ListNode currentB = head;
        ListNode prev = null;
        ListNode prevA = null;
        ListNode prevB = null;
        boolean hasA = false;
        boolean hasB = false;

        // find previousA and currentA, previousB and currentB
        while (null != current) {
            if (!hasA && a.val == current.val) {
                prevA = prev;
                currentA = current;
                hasA = true; // found node a
            } else if (!hasB && b.val == current.val) {
                prevB = prev;
                currentB = current;
                hasB = true; // found node b
            }

            if (hasA && hasB) {
                break; // if we found both nodes, exit the loop
            }
            // next iteration
            prev = current;
            current = current.next;
        }

        // if either of the node is not present, return null
        if (!hasA || !hasB) {
            return null;
        }

        // Swap A and B

        // if a is not the head
        if (null != prevA) {
            prevA.next = currentB;
        } else {
            result = currentB;
        }

        // if b is not the head
        if (null != prevB) {
            prevB.next = currentA;
        } else {
            result = currentA;
        }

        // swap next elements
        ListNode temp = currentA.next;
        currentA.next = currentB.next;
        currentB.next = temp;

        return result;
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

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<Integer> stack = new Stack();
        fast = head;
        while (null != slow) {
            stack.push(slow.val);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != fast.val) {
                return false;
            }
            fast = fast.next;
        }

        return true;
    }

    private static ListNode recRev(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode n = recRev(head.next);
        head.next.next = head; // takes a while to execute
        head.next = null;

        return n;
    }
}
