package leetcode.slidingwindow.minmaxmidean;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        // approach 1
        System.out.println("maxSlidingWindow({1,3,-1,-3,5,3,6,7}, 3) = " +
                Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        // approach 2
        System.out.println("maxSlidingWindowLR({1,3,-1,-3,5,3,6,7}, 3) = " +
                Arrays.toString(maxSlidingWindowLR(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // #1. using left, right traverse approach
    // https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array
    public static int[] maxSlidingWindowLR(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 1) {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        int[] left = new int[nums.length], right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            left[i] = i % k == 0 ? nums[i] : Math.max(nums[i], left[i - 1]);

            int j = nums.length - i - 1;
            right[j] = j % k == 0 ? nums[j] : Math.max(nums[j], right[j + 1]);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(right[i], left[i + k - 1]);
        }

        return result;
    }

    // #2. using priority queue
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k < 1) {
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> {
            return (b - a);
        });
        int end = 0;
        int[] res = new int[nums.length - k + 1];

        while (end < k) {
            pq.offer(nums[end]);
            end++;
        }

        int i = 0;
        while (end < nums.length) {
            res[i++] = pq.peek();
            pq.remove(nums[end - k]);

            int n = nums[end];
            pq.offer(n);

            end++;
        }
        res[i] = pq.peek();
        return res;
    }
}
