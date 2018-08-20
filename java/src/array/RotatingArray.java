package array;

public class RotatingArray {

    public static void main(String[] args) {
        //rotateArray(new int[]{1,2,3,4,5,6,7}, 3);
        //rotateReverse(new int[]{1,2,3,4,5,6,7}, 3);
        System.out.println("rotate array search: " + search(new int[]{10, 12, 13, 14, 15, 5, 6, 7, 8}, 25));
    }

    /**
     * Rotates input array by given number of shifts k
     * <p>
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
     */
    private static void rotateArray(int[] input, int k) {
        if (null == input || input.length < 2 || k < 1) {
            return;
        }
        if (k > input.length) {
            k = k % (input.length);
        }

        int[] result = new int[input.length];
        for (int i = 0; i < k; i++) {
            result[i] = input[input.length - k + i];
        }

        int j = 0;
        for (int i = k; i < input.length; i++) {
            result[i] = input[j];
            j++;
        }

        System.arraycopy(result, 0, input, 0, input.length);
    }

    private static void rotateReverse(int[] input, int k) {
        if (null == input || input.length < 2 || k < 1) {
            return;
        }

        // 1,2,3,4
        // 1. 4,3,2,1 (reverse whole array)
        // 2. 3,4 (reverse 0 to k)
        // 3. 1,2 (reverse k to n)
        // 4. 3,4,1,2 (combined array is result)
        reverse(input, 0, input.length - 1);
        reverse(input, 0, k - 1);
        reverse(input, k, input.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        if (null == arr || arr.length < 2 || start >= end) {
            return;
        }

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Binary search on a rotating array - {5,6,7,1,2,3,4}
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean search(int[] arr, int target) {
        if (null == arr || arr.length == 0) {
            return false;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return true;
            }

            if (arr[mid] <= arr[high]) { // Right side is sorted
                if (arr[mid] < target && target <= arr[high]) { // target is between mid and high
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[low] <= target && target < arr[mid]) { // target is between low and mid
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }
}