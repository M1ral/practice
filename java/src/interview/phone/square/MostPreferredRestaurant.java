package interview.phone.square;

import java.util.*;

/*
# Select the restaurant that most people prefer for lunch. If there is a tie
# then any of the tied restaurants may be selected.
#
#   preferences = {
#     jack:         ["a", "b", "c", "d", "e"], -->
#     krishnakumar: ["b", "c", "d", "e"],
#     don:          ["c", "d", "e"]
#   }
#
# restaurant  count
    a        5
    b        4+4 *
    c        3+3
    d        2
    e        1

#   choose(preferences) #=> ? # Return both the chosen restaurant and the number
#                             # of times it was found.
#
*/
public class MostPreferredRestaurant {
    public static void main(String[] args) {
        Map<String,List<String>> input = new HashMap<>();
        input.put("jack", Arrays.asList("d", "c", "b", "a", "e"));
        input.put("krishha", Arrays.asList("d", "c", "a", "e"));
        input.put("don", Arrays.asList("d", "c", "a"));

        System.out.println("getMostPreferred(input).name = " + getMostPreferred(input).name);
    }

    public static Restaurant getMostPreferred(Map<String, List<String>> preferences) {
        if (null == preferences || preferences.isEmpty()) {
            return null;
        }

        Map<String, Restaurant> restaurantsMap = new HashMap<>();
        PriorityQueue<Restaurant> pq = new PriorityQueue<>();

        for (String person : preferences.keySet()) {
            int offset = 0;
            for (String name : preferences.get(person)) {
                Restaurant r = restaurantsMap.getOrDefault(name, new Restaurant(name, 0));
                pq.remove(r); // log n
                r.count++;
                r.offset += offset++;
                restaurantsMap.put(name, r);
                pq.add(r); // log n
            }
        }

        // restaurantsMap.entrySet()
        // .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        return pq.peek();
    }
}

class Restaurant implements Comparable<Restaurant> {
    String name;
    int count;
    int offset;

    public Restaurant(String name, int offset) {
        this.name = name;
        this.count = 0;
        this.offset = offset;
    }

    @Override
    public int compareTo(Restaurant o) {
        return this.count == o.count
            ? this.offset - o.offset
            : o.count - this.count;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Restaurant)obj).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return name + " : " + "[count: "+ count +", offset: " + offset +"]";
    }
}
