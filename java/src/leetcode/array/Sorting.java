package leetcode.array;


import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] input = new int[] {1,5,3,2};
        bubbleSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[] {1,5,3,2};
        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void bubbleSort(int[] a) {
        if (null == a || a.length < 2) {
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 -i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int[] a) {
        if (null == a || a.length < 2) {
            return;
        }

        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j; // identify minimum in each iteration
                }
            }
            swap(a, i, min); // put the min at the ened
        }
    }

    public static void swap(int[] a, int src, int dest) {
        if (null == a || a.length < 2) {
            return;
        }

        int temp = a[src];
        a[src] = a[dest];
        a[dest] = temp;
    }
}
