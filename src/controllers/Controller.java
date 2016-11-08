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

    /**
     * Class made singleton
     * */
    private static Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    private Controller() {
    }

    public void registerUser(User user){
        /**
         * Method accepts user as an input and set registration flag to true
         * */
        user.setIsRegistered(true);
        System.out.println("User " + user + " is registered");
    }

    public void switchCurrentUser(User newUser){
        /**
         * Method to switch current user.
         * Accepts user as an input and set
         * the given user to current
         * */
        CurrentUser.getInstance().setUser(newUser);
        System.out.println("User " + newUser + " is current");
    }

    public Set<Hotel> findHotelByName(String name){
        /**
         * Method returns list of Hotels by name
         * if current user is registered
         * otherwise method returns message and empty list
         * */
        Set<Hotel> hotels = new HashSet<>();
        //Check if current user is registered
        if(CurrentUser.getInstance().getUser()!=null && CurrentUser.getInstance().getUser().getIsRegistered()) {
            //checks if hotel with given in input parameter hotel name exists
            hotels = HotelDAOImpl.getInstance().getAll()
                    .stream().filter(h -> h.getName().equals(name))
                    .collect(Collectors.toSet());
        }
        //return message for unregistered user
        else System.out.println("Unabale to execute operation. User is not registered");
        return hotels;
    }

    public Set<Hotel> findHotelByCity(String city){
        /**
         * Method returns list of Hotels in target city
         * if current user is registered
         * otherwise method returns message and empty list
         * */
        Set<Hotel> hotels = new HashSet<>();
        //check if user registered
        if(CurrentUser.getInstance().getUser()!=null && CurrentUser.getInstance().getUser().getIsRegistered()) {
            //checks if hotels in target city, given in input parameter, exist
            hotels = HotelDAOImpl.getInstance().getAll().stream()
                    .filter(h -> h.getCity().equals(city))
                    .collect(Collectors.toSet());
            return hotels;
        }
        //return message for unregistered user
        else System.out.println("Unabale to execute operation. User is not registered");
        return hotels;
    }

    public void bookRoom(long roomId, long userId, long hotelId){
        /**
         * If current user is registered, method searches needed room by using hotelId and roomId.
         * Also searches user, which wants to book room, using userId. If such room
         * exist and not reserved yet - sets needed room's field "isReserved" to true  and puts current user
         * to field "userReserved". Otherwise method returns message.
         */
        if(CurrentUser.getInstance().getUser()!=null && CurrentUser.getInstance().getUser().getIsRegistered()) {
            String hotelName = null;
            User user = null;
            String id = Long.toString(roomId);

            Iterator<Hotel> hotelIterator = HotelDAOImpl.getInstance().getAll().iterator();

            while (hotelIterator.hasNext()) {
                Hotel tmp = hotelIterator.next();
                if (tmp.getHotelId() == hotelId) {
                    hotelName = tmp.getName();
                    break;
                }
            }

            Iterator<User> userIterator = UserDAOImpl.getInstance().getAll().iterator();
            while (userIterator.hasNext()) {
                User tmp = userIterator.next();
                if (tmp.getUserId() == userId) {
                    user = tmp;
                }
            }

            Map<String, String> map = new HashMap<>();
            map.put("Hotel", hotelName);
            map.put("RoomId", id);

            if (findRoom(map).size() > 0) {
                Iterator<Room> roomIterator = findRoom(map).iterator();
                Room tmp = roomIterator.next();
                if(tmp.getIsReserved()) System.out.println("Room already reserved");
                else {
                    tmp.setIsReserved(true);
                    tmp.setUserReserved(user);
                    RoomDAOImpl.getInstance().save(tmp);
                    System.out.println("Room "+ tmp + " is reserved by user: " + user);
                }
            }
        }
        else{
            System.out.println("Unabale to execute operation. User is not registered");
        }
    }

    public void cancelReservation(long roomId, long userId, long hotelId){
        /**
         * If current user is registered, method searches needed room by using hotelId and roomId.
         * If such room exist and has been reserved by current user - sets needed room's field "isReserved" to false
         * and field "userReserved" to null. Otherwise method returns message.
         */
        if(CurrentUser.getInstance().getUser()!=null && CurrentUser.getInstance().getUser().getIsRegistered()) {
            String hotelName = null;
            String id = Long.toString(roomId);

            Iterator<Hotel> hotelIterator = HotelDAOImpl.getInstance().getAll().iterator();

            while (hotelIterator.hasNext()) {
                Hotel tmp = hotelIterator.next();
                if (tmp.getHotelId() == hotelId) {
                    hotelName = tmp.getName();
                    break;
                }
            }

            Map<String, String> map = new HashMap<>();
            map.put("Hotel", hotelName);
            map.put("RoomId", id);

            if (findRoom(map).size() > 0) {
                Iterator<Room> roomIterator = findRoom(map).iterator();
                while (roomIterator.hasNext()) {
                    Room tmp = roomIterator.next();
                   if (!tmp.getIsReserved()) System.out.println("Room is not reserved at the moment");
                    else {
                        if (!tmp.getUserReserved().equals(CurrentUser.getInstance().getUser())) {
                            System.out.println("Room is reserved by other user. You are not authorized cancel this reservation");
                        } else {
                            tmp.setIsReserved(false);
                            tmp.setUserReserved(null);
                            RoomDAOImpl.getInstance().save(tmp);
                            System.out.println("Room " + tmp + " reservation canceled");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Unabale to execute operation. User is not registered");
        }

    }

    public Set<Room> findRoom(Map<String, String> params){
        /**If current user is registered, method checks for which
         * parameters room's search has been set. After that creates
         * "neededRoom" which accord searching parameters and
         * compare "neededRoom" with available rooms. Returns
         * list of rooms which approach to user's request.
         * Otherwise method returns message and empty list
         *
         */
        if(CurrentUser.getInstance().getUser()!=null && CurrentUser.getInstance().getUser().getIsRegistered()) {
            Room neededRoom = new Room();
            Set<Room> findRooms = new HashSet<>();

            if (params.containsKey("City")) {
                neededRoom.setCity(params.get("City"));
            }
            if (params.containsKey("Hotel")) {
                neededRoom.setHotel(params.get("Hotel"));
            }
            if (params.containsKey("Price")) {
                try {
                    neededRoom.setPrice(Integer.valueOf(params.get("Price")));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong price");
                }
            }
            if (params.containsKey("Persons")) {
                try {
                    neededRoom.setPersons(Integer.valueOf(params.get("Persons")));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong persons");
                }
            }
            if (params.containsKey("RoomId")) {
                try {
                    neededRoom.setRoomId(Long.valueOf(params.get("RoomId")));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong Id");
                }
            }
            if (params.containsKey("From")) {

                String tmp = params.get("From");
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd.MM.yyyy");
                try {
                    Date date = format.parse(tmp);
                    neededRoom.setDateAvalibleFrom(date);
                } catch (ParseException e) {
                    System.out.println("Wrong date format");
                }
            }
//            if(params.containsKey("isReserved")){
//                neededRoom.setIsReserved(Boolean.parseBoolean(params.get("isReserved")));
//            }

            Iterator<Room> iterator = RoomDAOImpl.getInstance().getAll().iterator();
            while (iterator.hasNext()) {
                Room tmp = iterator.next();
                if (neededRoom.equals(tmp)) {
                    findRooms.add(tmp);
                }
            }
            return findRooms;
        }
        else{
            System.out.println("Unabale to execute operation. User is not registered");
            return new HashSet<>();
        }
    }
}