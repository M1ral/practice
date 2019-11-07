package leetcode.sorting;

import java.util.Arrays;

public class BubbleInsertionSelectionSorting {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 4, 56, 1, 55, 113, 657, 224, 223, 213, 123};
        bubbleSort(arr);
        System.out.println("bubble sort :" + Arrays.toString(arr));

        // reset array
        arr = new int[]{3, 5, 2, 4, 56, 1, 55, 113, 657, 224, 223, 213, 123};
        insertionSort(arr);
        System.out.println("insertion sort :" + Arrays.toString(arr));
    }

    // bubble sort
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // insertion sort
    public static void insertionSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j; // identify minimum in each iteration
                }
            }
            // swap i and min indices (bring min to front)
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    // selection sort
}
