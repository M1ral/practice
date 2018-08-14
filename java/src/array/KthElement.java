package array;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KthElement {

    public static void main(String[] args) {
        System.out.println("findKthLargest: " + findKthLargest(new int[]{2,3,4,1,7,0}, 3));
        System.out.println("findKthLargestHeap: " + findKthLargestHeap(new int[]{2,3,4,1,7,0}, 3));
        System.out.println("findKthSmallestHeap: " + findKthSmallestHeap(new int[]{2,3,4,1,7,0}, 5));
        System.out.println("most frequent k : " + Arrays.toString(mostFrequentK(new int[]{1,1,7,2,6,5,6,7}, 2)));
    }

    public static int findKthLargest(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return -1; // indicates an error in the input
        }
        if (k < 1 || k > arr.length) {
            return -1; // indicates an error in the input
        }

        Arrays.sort(arr);
        int index = arr.length - k;
        return arr[index];
    }

    public static int findKthLargestHeap(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);

        for(int i: arr){
            q.offer(i);

            if(q.size() > k){
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthSmallestHeap(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i: arr){
            q.offer(i);
        }

        int r = -1;
        while (k > 0) {
            r = q.poll();
            k--;
        }

        return r;
    }

    public static int[] mostFrequentK(int[] a, int k) {
        if (null == a || a.length == 0) {
            return null;
        }

        Map<Integer, Pair> treemap = new TreeMap<Integer, Pair>();
        for (int n : a) {
            if (treemap.containsKey(n)) {
                treemap.get(n).incrementCount();
            } else {
                treemap.put(n, new Pair(n, 1));
            }
        }

        int[] result = new int[k];
        int m = 0;

        for (int j : treemap.keySet()) {
            result[m] = j;
            if (m == k-1) {
                break;
            }
            m++;
        }

        return result;
    }


}
