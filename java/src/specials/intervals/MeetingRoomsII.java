package specials.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        System.out.println("minMeetingRooms({{2,15}, {36,45}, {9,29}, {16,23}, {4,9}}) = " +
                minMeetingRooms(new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}));
    }

    public static int minMeetingRooms(int[][] meetings) {
        if (null == meetings || meetings.length == 0) {
            return 0;
        }

        // Sort meetings based on start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        // Maintain minHeap by end time so that it will always
        // return the earliest time a meeting is ending
        // out of currently run meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(meetings[0][1]);

        for (int i=1; i < meetings.length; i++) {
            int[] current = meetings[i];
            int earliestEnd = minHeap.remove();

            if (current[0] >= earliestEnd) {
                earliestEnd = current[1];
            } else {
                minHeap.add(current[1]);
            }
            minHeap.add(earliestEnd);
        }
        // Note: MinHeap maintains all occupied rooms' end times
        return minHeap.size();
    }
}
