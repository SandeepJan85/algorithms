package org.unplugged.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public static void main(String[] a) {
        List<Integer> room1 = new ArrayList<>(Arrays.asList());
        List<Integer> room2 = new ArrayList<>(Arrays.asList());
        List<Integer> room3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> room4 = new ArrayList<>(Arrays.asList(0, 2));
        List<List<Integer>> rooms = Arrays.asList(room1, room2, room3, room4);
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> keysInFirstRoom = rooms.get(0);
        keysInFirstRoom.add(-1);
        markRoomsVisited(rooms, keysInFirstRoom);
        for (List<Integer> room : rooms) {
            if (room.isEmpty() || room.get(room.size() - 1) != -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Function that recursively marks each room that has been visited by adding '-1' to the list
     * of keys within each room as a marker so that it need not be visited again
     *
     * @param rooms - list of rooms that have the set of keys
     * @param keys - set of 0 or more keys within each room
     */
    public static void markRoomsVisited(List<List<Integer>> rooms, List<Integer> keys) {
        for (int i = 0; i < keys.size() - 1; i++) {
            List<Integer> keysInRoom = rooms.get(keys.get(i));
            if (!keysInRoom.isEmpty()) {
                if (keysInRoom.get(keysInRoom.size() - 1) != -1) {
                    keysInRoom.add(-1);
                    markRoomsVisited(rooms, keysInRoom);
                }
            } else {
                keysInRoom.add(-1);
            }
        }
    }
}
