package leetcode.sorting;

import java.util.Arrays;

public class AbsoluteValueSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(absSort(new int[]{2, -7, -2, -2, 0})));
    }

    public static int[] absSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        mergeSort(arr);
        return arr;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int begin, int end) {
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

        int i = begin, k = begin, j = mid + 1;
        int[] temp = new int[arr.length];

        while (i <= mid && j <= end) {
            int a = arr[i], b = arr[j];
            int aAbs = Math.abs(a), bAbs = Math.abs(b);

            // -2, 2 -  sort (a,b)
            // 0, 2 -  sort (a,b)
            // 0, -2 -  sort (aAbs, bAbs)
            // -2, -7 - sort (aAbs, bAbs)
            if (aAbs == bAbs) {
                if (a <= b) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            } else if (aAbs < bAbs) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (k = begin; k <= end; k++)
            arr[k] = temp[k];
    }
}
