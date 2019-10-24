package leetcode.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,8,12,23,1,20,9};
        mergeSort(arr);
        System.out.println("mergeSort(arr) = " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (null == arr || arr.length == 0) {
            return;
        }

        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        if (null == arr || arr.length == 0) {
            return;
        }

        int i = begin, j = mid + 1, k = begin;
        int[] temp = new int[arr.length];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= end)
            temp[k++] = arr[j++];

        for (k = begin; k <= end; k++)
            arr[k] = temp[k];
    }
}
