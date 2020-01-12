package leetcode.design;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream
public class RunningMedianOfAStream {

    public static void main(String[] args) {
        RunningMedianOfAStream stream = new RunningMedianOfAStream();
        stream.addNum(1);
        stream.addNum(2);
        stream.addNum(3);
        System.out.println("stream.findMedian() = " + stream.findMedian());
    }

    private Queue<Integer> small = new PriorityQueue<Integer>((a, b) -> (b - a));
    private Queue<Integer> large = new PriorityQueue();

    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}
