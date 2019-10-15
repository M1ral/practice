package leetcoce.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumHistogram {

    public static void main(String[] args) {
        System.out.println("getMaxRectInHistogram({1,2,3,0,6}) = " +
                getMaxRectInHistogram(new int[]{1, 2, 3, 0, 6}));
    }

    public static int getMaxRectInHistogram(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }

        int i = 0, n = arr.length, area = 0, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (i < n) {
            if (stack.isEmpty() || stack.peek() <= arr[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i-1-stack.peek());
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = arr[top] * i;
            } else {
                area = arr[top] * (i-1-stack.peek());
            }
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
