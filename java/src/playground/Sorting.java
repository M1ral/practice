package playground;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 9, 50, 18, 27, 0, 54};
        mergeSort(arr);
        System.out.println("Merge sort : arr = " + Arrays.toString(arr));

        int[] arr2 = {2, 4, 6, 1, 9, 50, 18, 27, 0, 54};
        mergeSort(arr2);
        System.out.println("Quick sort : arr = " + Arrays.toString(arr2));
    }

    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
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

        for (k = start; k <= end; k++)
            arr[k] = temp[k];
    }
}
