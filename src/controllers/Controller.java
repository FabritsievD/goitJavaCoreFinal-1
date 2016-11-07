package controllers;

import dao.HotelDAOImpl;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import entities.CurrentUser;
import entities.Hotel;
import entities.Room;
import entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    public void registerUser(User user){
        System.out.println("User " + user + " is registered");
    }
    public Set<Hotel> findHotelByName(String name){
        Set<Hotel> hotels = HotelDAOImpl.getInstance().getAll().stream().filter(h -> h.getName().equals(name)).collect(Collectors.toSet());
        return hotels;
    }

    public Set<Hotel> findHotelByCity(String city){
        Set<Hotel> hotels = HotelDAOImpl.getInstance().getAll().stream().filter(h -> h.getCity().equals(city)).collect(Collectors.toSet());
        return hotels;
    }

    public void bookRoom(long roomId, long userId, long hotelId){
        String hotelName = null;
        User user = null;
        String id = Long.toString(roomId);

        Iterator<Hotel> hotelIterator = HotelDAOImpl.getInstance().getAll().iterator();

        while (hotelIterator.hasNext()){
            Hotel tmp = hotelIterator.next();
            if(tmp.getHotelId()==hotelId){
                hotelName=tmp.getName();
                break;
            }
        }

        Iterator<User> userIterator = UserDAOImpl.getInstance().getAll().iterator();
        while (userIterator.hasNext()){
            User tmp = userIterator.next();
            if(tmp.getUserId()==userId){
                user = tmp;
            }
        }

        Map<String,String> map = new HashMap<>();
        map.put("Hotel",hotelName);
        map.put("RoomId",id);

        if(findRoom(map).size()>0){
            Iterator<Room> roomIterator = findRoom(map).iterator();
            Room tmp = roomIterator.next();
            tmp.setIsReserved(true);
            tmp.setUserReserved(user);
        }

    }

    public void cancelReservation(long roomId, long userId, long hotelId){
        String hotelName = null;
        String id = Long.toString(roomId);

        Iterator<Hotel> hotelIterator = HotelDAOImpl.getInstance().getAll().iterator();

        while (hotelIterator.hasNext()){
            Hotel tmp = hotelIterator.next();
            if(tmp.getHotelId()==hotelId){
                hotelName=tmp.getName();
                break;
            }
        }

        Map<String,String> map = new HashMap<>();
        map.put("Hotel",hotelName);
        map.put("RoomId",id);

        if(findRoom(map).size()>0){
            Iterator<Room> roomIterator = findRoom(map).iterator();
            Room tmp = roomIterator.next();
            tmp.setIsReserved(false);
            tmp.setUserReserved(null);
        }


    }

    public Set<Room> findRoom(Map<String, String> params){

        Room neededRoom = new Room();
        Set<Room> findRooms = new HashSet<>();

        if(params.containsKey("City")) {
            neededRoom.setCity(params.get("City"));
        }
        if(params.containsKey("Hotel")){
            neededRoom.setHotel(params.get("Hotel"));
        }
        if(params.containsKey("Price")){
            try{
                neededRoom.setPrice(Integer.valueOf(params.get("Price")));
            }
            catch (NumberFormatException e){
                System.out.println("Wrong price");
            }
        }
        if(params.containsKey("Persons")){
            try{
                neededRoom.setPersons(Integer.valueOf(params.get("Persons")));
            }
            catch (NumberFormatException e){
                System.out.println("Wrong persons");
            }
        }
        if(params.containsKey("RoomId")){
            try{
                neededRoom.setRoomId(Long.valueOf(params.get("Id")));
            }
            catch (NumberFormatException e){
                System.out.println("Wrong Id");
            }
        }
        if(params.containsKey("From")){

            String tmp = params.get("From");
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            try{
                Date date =format.parse(tmp);
                neededRoom.setDateAvalibleFrom(date);
            }
            catch (ParseException e){
                System.out.println("Wrong date format");
            }


        }

        Iterator<Room> iterator =  RoomDAOImpl.getInstance().getAll().iterator();
        while (iterator.hasNext()){
            Room tmp= iterator.next();
            if(neededRoom.equals(tmp)){
                findRooms.add(tmp);
            }
        }
        return findRooms;
    }
}