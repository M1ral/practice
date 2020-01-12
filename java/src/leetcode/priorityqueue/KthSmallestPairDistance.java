package leetcode.priorityqueue;

import java.util.Arrays;

// https://leetcode.com/problems/find-k-th-smallest-pair-distance
public class KthSmallestPairDistance {
    public static void main(String[] args) {
        System.out.println("smallestDistancePair({1,3,1}, 1) = " +
                smallestDistancePair(new int[]{1, 3, 1}, 1));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length - 1] + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (count >= k) {
                return i;
            }
        }
        return 0;
    }
}
