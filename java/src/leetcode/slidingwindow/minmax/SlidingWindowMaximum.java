package leetcode.slidingwindow.minmax;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println("maxSlidingWindow({1,3,-1,-3,5,3,6,7}, 3) = " +
                Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // using priority queue
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k > nums.length) {
            return new int[]{};
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (i1, i2) -> (Integer.compare(i2, i1)));
        int count = 0;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                pq.offer(nums[j]);
            }
            result[count] = pq.poll();
            pq.clear();
            count++;
        }

        return result;
    }
}
