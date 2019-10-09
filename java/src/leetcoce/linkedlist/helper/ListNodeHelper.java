package leetcoce.linkedlist.helper;

import leetcoce.linkedlist.pojo.ListNode;

public class ListNodeHelper {

    public static ListNode generateLinkedList(int[] values) {
        if (null == values || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode previous = head;

        for (int val : values) {
            ListNode n = new ListNode(val);
            previous.next = n;
            previous = n;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(generateLinkedList(new int[]{1,2,3,4,5}));
    }
 }
