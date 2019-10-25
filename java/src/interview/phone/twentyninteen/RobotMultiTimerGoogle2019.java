package interview.phone.twentyninteen;

import java.util.PriorityQueue;

public class RobotMultiTimerGoogle2019 {
    public static void main(String[] args) {
        Runnable DoWork1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("DoWork1");
            }
        };
        Runnable DoWork2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("DoWork1");
            }
        };
        Runnable DoWork3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("DoWork1");
            }
        };
        Runnable DoWork4 = new Runnable() {
            @Override
            public void run() {
                System.out.println("DoWork1");
            }
        };

        MultiTimer.set(DoWork1, 600);
        MultiTimer.set(DoWork1, 900);
        MultiTimer.set(DoWork1, 120);
        MultiTimer.set(DoWork1, 960);
    }
}

class Robot {
    /**
     *  Schedules call to callback after waitSecs.
     *  Cancels all prior scheduled callbacks. Returns immediately.
     */
    static void setTimer(Runnable callback, int waitSecs) {
        System.out.println("invoked after " + waitSecs + " calling : " + callback.toString());
    }

    /**
     * Returns the current system time.
     */
    public static long getTime() {
        return System.currentTimeMillis();
    }
}

class MultiTimer {
    private static PriorityQueue<Work> minHeap = new PriorityQueue<Work>();
    /**
     * Schedules call to callback after waitSecs.
     * Does not impact prior scheduled callbacks. Returns immediately.
     */
    public static void set(Runnable callback, int waitSecs) {
        if (callback == null || waitSecs < 0 ) {
            return;
        }

        // add work to priority queue
        //minHeap.add(new Work(waitSecs, callback, callRobot, markWorkDone));
        minHeap.add(new Work(waitSecs, callback));
        // call Robot
        callRobot();
    }

    private static void callRobot() {
        if (null == minHeap || minHeap.isEmpty()) {
            return;
        }
        // call the earliest occuring work
        if (!minHeap.isEmpty()) {
            Work work = minHeap.peek();
            Robot.setTimer(work.callback, work.waitSecs);
        }
    }

    private static void markWorkDone() {
        if (null == minHeap || minHeap.isEmpty()) {
            return;
        }
        // remove the earliest ending work
        Work removed = minHeap.remove();
        System.out.println("Removed : " + removed.callback.toString());
    }
}


class Work implements Comparable<Work> {
    int waitSecs;
    Runnable callback;

    /*public Work(int waitSecs, Runnable callback, Function afterCallBack, Function markWorkDone) {
        this.waitSecs = waitSecs;
        this.callback = Function {callback; markWorkDone.apply(null); afterCallBack.apply(null);};
    }*/

    public Work(int waitSecs, Runnable callback) {
        this.waitSecs = waitSecs;
        this.callback = callback;
    }

    public int compareTo(Work other) {
        return this.waitSecs - other.waitSecs;
    }
}
