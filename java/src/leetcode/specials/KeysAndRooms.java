package leetcode.specials;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }

    Map<Integer, Room> roomsMap = new HashMap();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (null == rooms || rooms.isEmpty()) {
            return false;
        }

        int roomNo = 0;
        for (List<Integer> keys : rooms) {
            roomsMap.put(roomNo, new Room(roomNo, keys));
            roomNo++;
        }

        // traverse from room 0
        visit(0);

        // check if all rooms are visited
        for (int roomNum : roomsMap.keySet()) {
            Room room = roomsMap.get(roomNum);
            if (null == room.keys || room.keys.isEmpty()) {
                continue;
            }
            if (!room.visited) {
                return false;
            }
        }

        return true;
    }

    private void visit(int roomNo) {
        // Mark the room visited
        roomsMap.get(roomNo).visited = true;

        // get keys
        List<Integer> keys = roomsMap.get(roomNo).keys;
        if (null == keys || keys.isEmpty()) {
            return;
        }
        // visit next rooms
        for (int key : keys) {
            if (!roomsMap.get(key).visited) {
                visit(key);
            }
        }
    }
}

class Room {
    int number;
    boolean visited;
    List<Integer> keys;

    public Room(int number, List<Integer> keys) {
        this.number = number;
        this.visited = false;
        this.keys = keys;
    }
}
