package leetcode.specials;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (null == routes || routes.length == 0) {
            return -1;
        }
        if (S == T) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap();
        Set<Integer> visited = new HashSet();
        List<Integer> buses = new ArrayList();
        Queue<Integer> Q = new LinkedList();
        int ret = 0;

        for (int i=0; i < routes.length; i++) {
            for (int j=0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList());
                }
                buses = map.get(routes[i][j]);
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        Q.offer(S);
        while (!Q.isEmpty()) {
            ret++;
            int len = Q.size();

            for (int i=0; i < len; i++) {
                int current = Q.poll();
                buses = map.get(current);

                for (int bus : buses) {
                    if (visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for (int j=0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) {
                            return ret;
                        }
                        Q.offer(routes[bus][j]);
                    }
                }
            }
        }

        return -1;
    }
}
