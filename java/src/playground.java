import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class playground {

    public static void main(String[] args) throws InvalidArgumentException{
        System.out.println("binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 2) = " +
                binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println("Arrays.toString(rotateArray(new int[] {1,2,3,4,5}, 3)) = " +
                Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5}, 3)));
        findElementPairsThatSumToGivenNumber(new int[]{1, 4, 7, 8}, 11);
        printTable(12);
        System.out.println(Arrays.toString(getFollowingElements(new Integer[]{1,2,3,4}, 2)));
        System.out.println(Arrays.toString(getFollowingElements(new String[]{"a","b","c","d"}, "d")));
    }

    public static int binarySearch(int[] arr, int val) {
        if (null == arr || arr.length == 0) {
            return -1;
        }

        int index = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < val) {
                start = mid + 1;
            } else if (arr[mid] > val) {
                end = mid - 1;
            } else if (arr[mid] == val) {
                index = mid;
                break;
            }
        }

        return index;
    }

    private static int[] rotateArray(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k <= 0) {
            return null;
        }

        if (k > arr.length) {
            k = k % arr.length;
        }

        int[] r = new int[arr.length];
        for (int i = 0; i < k; i++) {
            r[i] = arr[arr.length - k + i];
        }

        int j = 0;
        for (int i = k; i < arr.length; i++) {
            r[i] = arr[j];
            j++;
        }

        return r;
    }


    // {1, 4, 7, 8}
    // {1:0, 4:1, 7:2, 8:4}
    // {10, 7, 4, 3}
    private static void findElementPairsThatSumToGivenNumber(int[] arr, int sum) {
        if (null == arr || arr.length == 0) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            Integer candidate = map.get(sum - arr[i]);
            if (candidate != null && candidate != i) {
                System.out.println(arr[i] + " + " + (sum - arr[i]) + " = " + sum);
            }
        }
    }

    private static void printTable(int n) {
        if (n < 1) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i*j + "\t");
            }
            System.out.print("\n");
        }
    }

    private static <T> T[] getFollowingElements(T[] elements, T e) throws InvalidArgumentException{
        if (null == elements || elements.length == 0) {
            return null;
        }
        if (null == e) {
            throw new InvalidArgumentException(new String[]{"Invalid input"});
        }
        int index = 0;
        for (T t : elements) {
            if (t.equals(e)) {
                index++;
                break;
            }
            index++;
        }

        T[] result = (T[]) new Object[elements.length];
        for (int i = index; i < elements.length; i++) {
            result[i] = elements[index];
        }

        return result;
    }
}
