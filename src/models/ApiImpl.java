package models;


import entities.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ApiImpl implements API {


    @Override
    public void bookRoom(long roomId, long userId, long hotelId) {

    }

    @Override
    public void cancelReservation(long roomId, long userId, long hotelId) {

    }

    @Override
    public HashSet<Room> findRoom(Map<String, String> params) {
//
//
//        Set<Room> rooms = new HashSet<>();
//        rooms.add(new Room(85236, 2, 700, "Hotel4", "City1", true, new Date("2016/10/16")));
//        rooms.add(new Room(95423, 6, 300, "Hotel5", "City2", true, new Date("2016/9/16")));
//        rooms.add(new Room(45796, 4, 800, "Hotel1", "City3", true, new Date("2016/10/16")));
//        rooms.add(new Room(49654, 1, 200, "Hotel2", "City4", true, new Date("2016/9/16")));
//        rooms.add(new Room(89134, 3, 600, "Hotel4", "City1", true, new Date("2016/10/16")));
//        rooms.add(new Room(87563, 5, 300, "Hotel3", "City3", true, new Date("2016/9/16")));
//
//        //DataBase db= new DataBase(rooms);
//
//        Room neededRoom = new Room();
//        HashSet<Room> findRooms = new HashSet<>();
//        if (params.containsKey("City")) {
//            neededRoom.setCity(params.get("City"));
//        }
//        if (params.containsKey("Hotel")) {
//            neededRoom.setHotel(params.get("Hotel"));
//        }
//        if (params.containsKey("Price")) {
//            try {
//                neededRoom.setPrice(Integer.valueOf(params.get("Price")));
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong price");
//            }
//        }
//        if (params.containsKey("Persons")) {
//            try {
//                neededRoom.setPersons(Integer.valueOf(params.get("Persons")));
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong persons");
//            }
//        }
//        if (params.containsKey("Id")) {
//            try {
//                neededRoom.setRoomId(Long.valueOf(params.get("Id")));
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong Id");
//            }
//        }
//        if (params.containsKey("From")) {
//
//            String tmp = params.get("From");
//            SimpleDateFormat format = new SimpleDateFormat();
//            format.applyPattern("dd.MM.yyyy");
//            try {
//                Date date = format.parse(tmp);
//                neededRoom.setDateAvalibleFrom(date);
//            } catch (ParseException e) {
//                System.out.println("Wrong date format");
//            }
//
//
//        }
//
//        Iterator<Room> iterator =  db.getRooms().iterator();
//        while (iterator.hasNext()){
//            Room tmp= iterator.next();
//            if(neededRoom.equals(tmp)){
//                findRooms.add(tmp);
//            }
//        }
//        return findRooms;
        return null;
    }
}
