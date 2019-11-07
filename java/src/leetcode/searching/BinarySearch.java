package leetcode.searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 9, 10, 34, 56, 67, 78, 89, 90};
        System.out.println("binary search recursive: " + searchRec(arr, 0, arr.length - 1, 90));
        System.out.println("binary search iterative: " + searchIter(arr, 56));
    }

    public static boolean searchRec(int[] arr, int begin, int end, int target) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        if (begin > end) {
            return false;
        }

        int mid = (begin + end) / 2;
        if (target == arr[mid]) {
            return true;
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            begin = mid + 1;
        }

        return searchRec(arr, begin, end, target);
    }

    public static boolean searchIter(int[] arr, int target) {
        if (null == arr || arr.length == 0) {
            return false;
        }

        int begin = 0, end = arr.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return false;
    }
}
