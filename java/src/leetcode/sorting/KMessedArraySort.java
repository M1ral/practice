package leetcode.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KMessedArraySort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));
    }

    public static int[] sortKMessedArray(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        if (k > arr.length) {
            return arr;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (i <= k) {
            pq.add(arr[i++]);
        }

        for (i = k+1; i < arr.length; i++) {
            arr[i - k - 1] = pq.remove();
            pq.add(arr[i]);
        }

        i = arr.length - k - 1;
        while (!pq.isEmpty()) {
            arr[i++] = pq.remove();
        }

        return arr;
    }
}
