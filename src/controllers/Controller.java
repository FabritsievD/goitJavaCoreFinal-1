package controllers;

import dao.HotelDAOImpl;
import entities.CurrentUser;
import entities.Hotel;
import entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Controller {
    public void registerUser(User user){
        CurrentUser currentUser = new CurrentUser(user);
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

    public void bookRoom(long roomId, long userId, long hotelId){}

    public void cancelReservation(long roomId, long userId, long hotelId){}

    public static Set<Hotel> findRoom(Map<String, String> params){
        //Output sample: city - Kiev, hotelName - Radisson, price - 200, persons - 2
        return null;
    }
}