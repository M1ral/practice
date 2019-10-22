package leetcode.linkedlist.pojo;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public String toString() {
        if (null == this) {
            return "NULL";
        }

        ListNode n = this;
        StringBuilder sb = new StringBuilder();
        while (null != n) {
            sb.append(n.val).append("->");
            n = n.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
