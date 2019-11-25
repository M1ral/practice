package interview.phone.twitter;

import java.util.*;

enum Granularity {
    MINUTE, HOUR, DAILY
}

public interface TweetCountingService {
    public void recordTweetEvent(String eventName, long timeInMillis);
    public long[] getTweetCounts(Granularity granularity, String eventName, long startTime, long endTime);
}

class TweetCountingServiceImpl implements TweetCountingService {

    Map<String, TweetEvent> map = new HashMap();

    @Override
    public void recordTweetEvent(String eventName, long timeInMillis) {
        if (null == eventName || eventName.isEmpty() || timeInMillis < 0) {
            return;
        }

        TweetEvent event = map.getOrDefault(eventName, new TweetEvent(eventName));
        event.recordTime(timeInMillis);

        map.put(eventName, event);
    }

    @Override
    public long[] getTweetCounts(Granularity granularity, String eventName, long startTime, long endTime) {
        List<Long> times = map.get(eventName).times;
        System.out.println("map.get(eventName).times = " + times);
        return times.stream().mapToLong(i -> i).toArray();
    }

    public static void main(String[] args) {
        TweetCountingService tweetCountingService = new TweetCountingServiceImpl();
        tweetCountingService.recordTweetEvent("tweet1", 5);
        tweetCountingService.recordTweetEvent("tweet1", 1);
        tweetCountingService.recordTweetEvent("tweet1", 2);

        tweetCountingService.recordTweetEvent("tweet2", 6);
        tweetCountingService.recordTweetEvent("tweet2", 2);
        tweetCountingService.recordTweetEvent("tweet2", 4);

        System.out.println("tweetCountingService.getTweetCounts(Granularity.MINUTE, \"tweet1\", 0, 100) = " +
                Arrays.toString(tweetCountingService.getTweetCounts(Granularity.MINUTE, "tweet1", 0, 100)));
    }
}

class TweetEvent {
    String name;
    List<Long> times;

    public TweetEvent(String name) {
        this.name = name;
        if (null == times) {
            times = new ArrayList<Long>();
        }
    }

    public void recordTime(long timeInMillis) {
        times.add(timeInMillis);
        Collections.sort(times, (t1, t2) -> t1.compareTo(t2));
    }
}