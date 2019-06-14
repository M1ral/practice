package array;

import java.util.*;

public class KthElement {

    public static void main(String[] args) {
        System.out.println("findKthLargest: " + findKthLargest(new int[]{2, 3, 4, 1, 7, 0}, 3));
        System.out.println("findKthLargestHeap: " + findKthLargestHeap(new int[]{1,2,3,4,5}, 2));
        System.out.println("findKthSmallest: " + findKthSmallest(new int[]{2, 3, 4, 1, 7, 0}, 5));
        System.out.println("findKthSmallestHeap: " + findKthSmallestHeap(new int[]{2, 3, 4, 1, 7, 0}, 5));

        // To use the utility class NRecord
        KthElement ke = new KthElement();
        System.out.println("most frequent k : " + ke.mostFrequentK(new int[]{1, 1, 7, 2, 6, 5, 6, 7}, 3).toString());

        int[] input = new int[]{1, 1, 7, 2, 6, 5, 6, 7};
        rotateByKElements(input, 3);
        System.out.println("rotate by k elements : " + Arrays.toString(input));
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
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for (int i : arr) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static int findKthSmallest(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        if (k < 0 || k > arr.length) {
            return -1;
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static int findKthSmallestHeap(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for (int i : arr) {
            q.offer(i);
        }

        int r = -1;
        while (k > 0) {
            r = q.poll();
            k--;
        }

        return r;
    }

    /**
     * Find k most frequently occurring numbers in given array
     *
     * @param a
     * @param k
     * @return List of Integers
     */
    public List<Integer> mostFrequentK(int[] a, int k) {
        if (null == a || a.length == 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        Map<Integer, NRecord> map = new HashMap<>();
        for (int n : a) {
            map.putIfAbsent(n, new NRecord(n, 0));
            map.get(n).incrementCount();
        }

        /*PriorityQueue<Record> queue = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.count - o2.count;
            }
        });*/

        PriorityQueue<NRecord> queue = new PriorityQueue(); // comparator is implemented in the Record class compareTo() method
        for (NRecord record : map.values()) {
            queue.offer(record);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        // queue holds the result
        while (!queue.isEmpty()) {
            result.add(queue.poll().num);
        }

        return result;
    }

    /**
     * Rotate given array by k elements
     *
     * @param arr
     * @param k
     */
    public static void rotateByKElements(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return;
        }

        if (k < 0) {
            return;
        }

        if (k > arr.length) {
            k = (k % arr.length);
        }

        int result[] = new int[arr.length];
        for (int i = 0; i < k; i++) {
            result[i] = arr[arr.length - k + i];
        }

        int j = 0;
        for (int i = k; i < arr.length; i++) {
            result[i] = arr[j];
            j++;
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }
}

// utility class
class NRecord implements Comparable<NRecord> {
    public int num;
    public int count;

    public void incrementCount() {
        this.count++;
    }

    public int compareTo(NRecord other) {
        return this.count - other.count;
    }

    public NRecord(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
