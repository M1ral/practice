package leetcode.specials;

import java.util.*;

public class KeysAndRoomsImproved {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(new KeysAndRoomsImproved().canVisitAllRooms(rooms));
    }

    Set<Integer> visitedRooms = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (null == rooms || rooms.isEmpty()) {
            return false;
        }
        // start visiting rooms
        visit(0, rooms);
        return visitedRooms.size() == rooms.size();
    }

    private void visit(int room, List<List<Integer>> rooms) {
        // visit room
        visitedRooms.add(room);
        for (int key : rooms.get(room)) {
            if (!visitedRooms.contains(key)) {
                visit(key, rooms);
            }
        }
    }
}
