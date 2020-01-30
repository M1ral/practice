package leetcode.intervals;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        System.out.println("canAttendMeetings = " +
                canAttendMeetings(new Interval[]{
                        new Interval(0, 30),
                        new Interval(15, 45),
                        new Interval(60, 75),
                }));

        System.out.println("canAttendMeetings = " +
                canAttendMeetings(new Interval[]{
                        new Interval(0, 15),
                        new Interval(15, 45),
                        new Interval(60, 75),
                }));
    }

    public static boolean canAttendMeetings(Interval[] meetings) {
        if (null == meetings || meetings.length <= 1) {
            return true;
        }

        Arrays.sort(meetings, (m1, m2) -> (m1.start - m2.start));

        for (int i = 0; i < meetings.length - 1; i++) {
            if (meetings[i].end > meetings[i+1].start) {
                return false;
            }
        }

        return true;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}
