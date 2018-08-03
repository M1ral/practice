package array;

public class RotatingArray {

    public static void main(String[] args) {
        rotateArray(new int[]{1,2,3,4,5,6,7}, 3);
        rotateReverse(new int[]{1,2,3,4,5,6,7}, 3);
    }

    /**
     * Rotates input array by given number of shifts k
     *
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
        reverse(input, 0, k-1);
        reverse(input, k, input.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        if (null == arr || arr.length < 2 || start >= end) {
            return;
        }

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
