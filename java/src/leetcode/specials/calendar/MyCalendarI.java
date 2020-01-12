package leetcode.specials.calendar;

import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-i/
public class MyCalendarI {

    public static void main(String[] args) {
        MyCalendarI calendar = new MyCalendarI();
        System.out.println("book(10, 20) = " + calendar.book(10, 20));
        System.out.println("book(15, 20) = " + calendar.book(15, 25));
        System.out.println("book(20, 40) = " + calendar.book(20, 40));
    }

    private TreeMap<Integer, Integer> calendar = null;

    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (start < 0 || end < 0 || end <= start) {
            return false;
        }

        // previous meeting
        Integer floorKey = calendar.floorKey(start);
        if (null != floorKey && calendar.get(floorKey) > start) return false;

        // next meeting
        Integer ceilingKey = calendar.ceilingKey(start);
        if (null != ceilingKey && ceilingKey < end) return false;

        calendar.put(start, end);
        return true;
    }
}
