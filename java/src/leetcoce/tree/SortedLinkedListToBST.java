package leetcoce.tree;

import leetcoce.linkedlist.helper.ListNodeHelper;
import leetcoce.linkedlist.pojo.ListNode;

import static leetcoce.tree.LinkedListAtLevels.getLinkedListAtEachDepth;
import static leetcoce.tree.LinkedListAtLevels.printLists;

public class SortedLinkedListToBST {

    public static void main(String[] args) {
        TreeNode root =
                sortedListToBST(ListNodeHelper.generateLinkedList(new int[]{1,2,3,4,5,6,7}));
        printLists(getLinkedListAtEachDepth(root));
    }

    private static ListNode h;
    public static TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }
        h = head;
        return addToTree(0, getLength(head) - 1);
    }

    private static TreeNode addToTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;

        TreeNode left = addToTree(start, mid - 1);

        TreeNode root = new TreeNode(h.val);
        h = h.next; // while performing Inorder traversal, visit next node of the leetcoce.linkedlist

        TreeNode right = addToTree(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    public static int getLength(ListNode head) {
        if (null == head) {
            return 0;
        }
        int length = 0;
        while (null != head) {
            length++;
            head = head.next;
        }
        return length;
    }
}
