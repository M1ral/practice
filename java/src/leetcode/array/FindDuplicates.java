package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicates(new int[]{1,2,3,4,5,6,7},
                new int[]{4,5,5,5,6,6,7,7,8,10,13,15,56,67,88,99})));
    }

    public static int[] findDuplicates(int[] arr1, int[] arr2) {
        if (null == arr1 || arr1.length == 0) {
            return new int[]{};
        }
        if (null == arr2 || arr2.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList();
        for (int n : arr1) {
            // binary search arr2 for n
            if (binarySearch(n, arr2)) {
                list.add(n);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;

        for (int i : list)
            result[index++] = i;

        return result;
    }

    public static boolean binarySearch(int target, int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
