package iterator;

import java.util.*;

public class SortedArrayIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        List<Integer> listOne = Arrays.asList(1,5,9,10);
        List<Integer> listTwo = Arrays.asList(2,4,6);
        List<Integer> listThree = Arrays.asList(3,7,11);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(listOne);
        lists.add(listTwo);
        lists.add(listThree);

        SortedArrayIterator si = new SortedArrayIterator(lists);
        while (si.hasNext()) {
            System.out.println("si.next() = " + si.next());
        }
    }

    private PriorityQueue<Node> pq;
    private List<List<Integer>> lists;

    public SortedArrayIterator(List<List<Integer>> lists) {
        if (null == lists || lists.isEmpty()) {
            return;
        }

        this.lists = lists;
        pq = new PriorityQueue<>((Node n1, Node n2) -> n1.val - n2.val);
        int listIndex = 0;
        for (List<Integer> list : lists) {
            pq.offer(new Node(0, list.get(0), listIndex));
            listIndex++;
        }
    }

    @Override
    public boolean hasNext() {
        return !pq.isEmpty();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Node ret = pq.poll();
            if (ret.itemIndex < lists.get(ret.listIndex).size() - 1) {
                Node toAdd = new Node(ret.itemIndex+1, lists.get(ret.listIndex).get(ret.itemIndex+1), ret.listIndex);
                pq.offer(toAdd);
            }
            return ret.val;
        } else {
            return -1;
        }
    }
}

class Node {
    public int val;
    public int listIndex;
    public int itemIndex;

    public Node(int itemIndex, int val, int listIndex) {
        this.itemIndex = itemIndex;
        this.listIndex = listIndex;
        this.val = val;
    }
}
