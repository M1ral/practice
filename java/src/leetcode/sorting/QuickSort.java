package leetcode.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 12, 23, 1, 20, 9};
        quickSort(arr);
        System.out.println("quickSort(arr) = " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (null == arr || arr.length == 0) {
            return;
        }

        if (start < end) {
            int location = partition(arr, start, end);
            quickSort(arr, start, location - 1);
            quickSort(arr, location + 1, end);
        }
    }

    // backbone of the logic
    // find the proper place for pivot
    public static int partition(int[] arr, int start, int end) {
        int left = start, right = end, pivot = arr[left];

        while (left < right) {
            while (left <= right && arr[left] <= pivot)
                left++;

            while (left <= right && arr[right] > pivot)
                right--;

            if (left < right)
                swap(arr, left, right);
        }

        // swap pivot with right position
        swap(arr, start, right);
        return right;
    }

    public static void swap(int[] arr, int src, int dest) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }
}
