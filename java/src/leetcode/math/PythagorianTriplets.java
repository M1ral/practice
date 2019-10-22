package leetcode.math;

import java.util.*;

public class PythagorianTriplets {

    public static void main(String[] args) {
        printPythagorianTriplets(10);
        System.out.println("In array: ----------------------");
        List<List<Integer>> lists = findPythagorianTripletsInArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        for (List<Integer> list : lists)
            System.out.println(list);
    }

    /**
     * Prints pythagorian triplets between 0 to given number n
     *
     * @param n
     */
    public static void printPythagorianTriplets(int n) {
        if (n <= 0) {
            return;
        }
        // idea is, c^2 = a^2 + b^2 and sqrt(c^2) is non decimal number
        // then a, b and c are pythagorian triplets
        // O(n) = O(n^2)
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                double cSqRoot = Math.sqrt(a * a + b * b);
                if (cSqRoot == Math.ceil(cSqRoot)) {
                    System.out.println(a + " " + b + " " + (int) cSqRoot);
                }
            }
        }
    }

    // flavor of 3Sum
    public static List<List<Integer>> findPythagorianTripletsInArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] arr = Arrays.copyOf(nums, nums.length);
        // sort array
        Arrays.sort(arr);

        // square each element
        int index = 0;
        for (int n : arr) {
            arr[index++] = n * n;
        }

        Set<List<Integer>> set = new HashSet<>();
        // find 3Sum, start from end
        for (int i = arr.length - 1; i > 0; i--) {
            int begin = 0, end = i - 1;
            while (begin < end) {
                int sum = arr[begin] + arr[end];
                if (sum == arr[i]) {
                    // System.out.println(arr[i] + " " + arr[begin] + " " + arr[end]);
                    set.add(Arrays.asList(nums[begin], nums[end], nums[i]));
                    begin++;
                    end--;
                } else if (sum < arr[i]) {
                    begin++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
