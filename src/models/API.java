package models;


import entities.Room;

import java.util.HashSet;
import java.util.Map;

public interface API {

    void bookRoom(long roomId, long userId, long hotelId);

    void cancelReservation(long roomId, long userId, long hotelId);

    HashSet<Room> findRoom(Map<String, String> params);
}
