package leetcode.slidingwindow.minmax;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-median/
public class SlidingWindowMedian {
    public static void main(String[] args) {
        System.out.println("medianSlidingWindow({1,3,-1,-3, 2, 1, 2}, 3) = " +
                Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }

            if (left.size() + right.size() == k) {
                double median;
                if (left.size() == right.size()) {
                    median = (double) ((long) left.peek() + (long) right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return result;
    }
}
