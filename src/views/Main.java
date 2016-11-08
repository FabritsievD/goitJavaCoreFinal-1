package views;

import controllers.Controller;
import dao.HotelDAOImpl;
import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import entities.Hotel;
import entities.Room;
import entities.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /***Create entities and test DAO***/

        //Create users
        User u01 = new User(1001L, "John", "Doe");
        User u02 = new User(1002L, "Josh", "Smith");
        User u03 = new User(1003L, "Lenny", "Duglas");
        //Add users to set
        Set<User> userSet = new HashSet<>();
        userSet.add(u01);
        userSet.add(u02);
        userSet.add(u03);
        //save all users
        UserDAOImpl.getInstance().saveAll(userSet);

        //Create Hotels and Rooms
        //Create Hotel #1 in City #1
        Hotel h01 = new Hotel(1L,"Kiev","Hilton", 5, null);
        //Create rooms for Hotel #1
        Room r01 = new Room(101L,2,200,"Hilton","Kiev",false,null,null);
        Room r02 = new Room(102L,1,120,"Hilton","Kiev",false,null,null);
        Room r03 = new Room(103L,3,230,"Hilton","Kiev",false,null,null);
        Room r04 = new Room(104L,4,280,"Hilton","Kiev",false,null,null);
        Room r05 = new Room(105L,2,200,"Hilton","Kiev",false,null,null);
        Room r06 = new Room(106L,2,200,"Hilton","Kiev",false,null,null);
        Room r07 = new Room(107L,1,120,"Hilton","Kiev",false,null,null);
        Room r08 = new Room(108L,3,230,"Hilton","Kiev",false,null,null);
        Room r09 = new Room(109L,4,280,"Hilton","Kiev",false,null,null);
        Room r10 = new Room(110L,2,200,"Hilton","Kiev",false,null,null);
        //add rooms for Hotel #1 to set
        Set<Room> hotel01RoomSet = new HashSet<>();
        hotel01RoomSet.add(r01);
        hotel01RoomSet.add(r02);
        hotel01RoomSet.add(r03);
        hotel01RoomSet.add(r04);
        hotel01RoomSet.add(r05);
        hotel01RoomSet.add(r06);
        hotel01RoomSet.add(r07);
        hotel01RoomSet.add(r08);
        hotel01RoomSet.add(r09);
        hotel01RoomSet.add(r10);
        //set Hotel #1 rooms
        h01.setRooms(hotel01RoomSet);

        //Create Hotel #2 in City #1
        Hotel h02 = new Hotel(2L,"Kiev","Redisson", 5, null);
        //Create rooms for Hotel #2
        Room r11 = new Room(201L,2,200,"Redisson","Kiev",false,null,null);
        Room r12 = new Room(202L,1,120,"Redisson","Kiev",false,null,null);
        Room r13 = new Room(203L,3,230,"Redisson","Kiev",false,null,null);
        Room r14 = new Room(204L,4,280,"Redisson","Kiev",false,null,null);
        Room r15 = new Room(205L,2,200,"Redisson","Kiev",false,null,null);
        Room r16 = new Room(206L,2,200,"Redisson","Kiev",false,null,null);
        Room r17 = new Room(207L,1,120,"Redisson","Kiev",false,null,null);
        Room r18 = new Room(208L,3,230,"Redisson","Kiev",false,null,null);
        Room r19 = new Room(209L,4,280,"Redisson","Kiev",false,null,null);
        Room r20 = new Room(210L,2,200,"Redisson","Kiev",false,null,null);
        //add rooms for Hotel #2 to set
        Set<Room> hotel02RoomSet = new HashSet<>();
        hotel02RoomSet.add(r11);
        hotel02RoomSet.add(r12);
        hotel02RoomSet.add(r13);
        hotel02RoomSet.add(r14);
        hotel02RoomSet.add(r15);
        hotel02RoomSet.add(r16);
        hotel02RoomSet.add(r17);
        hotel02RoomSet.add(r18);
        hotel02RoomSet.add(r19);
        hotel02RoomSet.add(r20);
        //set Hotel #2 rooms
        h02.setRooms(hotel02RoomSet);


        //Create Hotel #3 in City #2
        Hotel h03 = new Hotel(3L,"Lviv","Ibis", 4, null);
        //Create rooms for Hotel #3
        Room r21 = new Room(301L,2,150,"Ibis","Lviv",false,null,null);
        Room r22 = new Room(302L,1,80,"Ibis","Lviv",false,null,null);
        Room r23 = new Room(303L,3,200,"Ibis","Lviv",false,null,null);
        Room r24 = new Room(304L,4,250,"Ibis","Lviv",false,null,null);
        Room r25 = new Room(305L,2,150,"Ibis","Lviv",false,null,null);
        Room r26 = new Room(306L,2,150,"Ibis","Lviv",false,null,null);
        Room r27 = new Room(307L,1,100,"Ibis","Lviv",false,null,null);
        Room r28 = new Room(308L,3,200,"Ibis","Lviv",false,null,null);
        Room r29 = new Room(309L,4,250,"Ibis","Lviv",false,null,null);
        Room r30 = new Room(310L,2,150,"Ibis","Lviv",false,null,null);
        //add rooms for Hotel #3 to set
        Set<Room> hotel03RoomSet = new HashSet<>();
        hotel03RoomSet.add(r21);
        hotel03RoomSet.add(r22);
        hotel03RoomSet.add(r23);
        hotel03RoomSet.add(r24);
        hotel03RoomSet.add(r25);
        hotel03RoomSet.add(r26);
        hotel03RoomSet.add(r27);
        hotel03RoomSet.add(r28);
        hotel03RoomSet.add(r29);
        hotel03RoomSet.add(r30);
        //set Hotel #3 rooms
        h03.setRooms(hotel03RoomSet);

        //Create Hotel #4 in City #2
        Hotel h04 = new Hotel(4L,"Lviv","Leotel", 4, null);
        //Create rooms for Hotel #4
        Room r31 = new Room(401L,2,190,"Leotel","Lviv",false,null,null);
        Room r32 = new Room(402L,1,100,"Leotel","Lviv",false,null,null);
        Room r33 = new Room(403L,3,220,"Leotel","Lviv",false,null,null);
        Room r34 = new Room(404L,4,270,"Leotel","Lviv",false,null,null);
        Room r35 = new Room(405L,2,180,"Leotel","Lviv",false,null,null);
        Room r36 = new Room(406L,2,180,"Leotel","Lviv",false,null,null);
        Room r37 = new Room(407L,1,120,"Leotel","Lviv",false,null,null);
        Room r38 = new Room(408L,3,230,"Leotel","Lviv",false,null,null);
        Room r39 = new Room(409L,4,270,"Leotel","Lviv",false,null,null);
        Room r40 = new Room(410L,2,180,"Leotel","Lviv",false,null,null);
        //add rooms for Hotel #4 to set
        Set<Room> hotel04RoomSet = new HashSet<>();
        hotel04RoomSet.add(r31);
        hotel04RoomSet.add(r32);
        hotel04RoomSet.add(r33);
        hotel04RoomSet.add(r34);
        hotel04RoomSet.add(r35);
        hotel04RoomSet.add(r36);
        hotel04RoomSet.add(r37);
        hotel04RoomSet.add(r38);
        hotel04RoomSet.add(r39);
        hotel04RoomSet.add(r40);
        //set Hotel #4 rooms
        h04.setRooms(hotel04RoomSet);

        //Create Hotel #5 in City #3
        Hotel h05 = new Hotel(5L,"Odesa","Wall Street Hotel", 5, null);
        //Create rooms for Hotel #5
        Room r41 = new Room(501L,2,190,"Wall Street Hotel","Odesa",false,null,null);
        Room r42 = new Room(502L,1,100,"Wall Street Hotel","Odesa",false,null,null);
        Room r43 = new Room(503L,3,220,"Wall Street Hotel","Odesa",false,null,null);
        Room r44 = new Room(504L,4,270,"Wall Street Hotel","Odesa",false,null,null);
        Room r45 = new Room(505L,2,180,"Wall Street Hotel","Odesa",false,null,null);
        Room r46 = new Room(506L,2,180,"Wall Street Hotel","Odesa",false,null,null);
        Room r47 = new Room(507L,1,120,"Wall Street Hotel","Odesa",false,null,null);
        Room r48 = new Room(508L,3,230,"Wall Street Hotel","Odesa",false,null,null);
        Room r49 = new Room(509L,4,270,"Wall Street Hotel","Odesa",false,null,null);
        Room r50 = new Room(510L,2,180,"Wall Street Hotel","Odesa",false,null,null);
        
        //add rooms for Hotel #5 to set
        Set<Room> hotel05RoomSet = new HashSet<>();
        hotel05RoomSet.add(r41);
        hotel05RoomSet.add(r42);
        hotel05RoomSet.add(r43);
        hotel05RoomSet.add(r44);
        hotel05RoomSet.add(r45);
        hotel05RoomSet.add(r46);
        hotel05RoomSet.add(r47);
        hotel05RoomSet.add(r48);
        hotel05RoomSet.add(r49);
        hotel05RoomSet.add(r50);

        //set Hotel #5 rooms
        h05.setRooms(hotel05RoomSet);

        //Create Hotel #6 in City #3
        Hotel h06 = new Hotel(6L,"Odesa","Bristol Hotel", 5, null);
        //Create rooms for Hotel #6
        Room r51 = new Room(601L,2,190,"Bristol Hotel","Odesa",false,null,null);
        Room r52 = new Room(602L,1,100,"Bristol Hotel","Odesa",false,null,null);
        Room r53 = new Room(603L,3,220,"Bristol Hotel","Odesa",false,null,null);
        Room r54 = new Room(604L,4,270,"Bristol Hotel","Odesa",false,null,null);
        Room r55 = new Room(605L,2,180,"Bristol Hotel","Odesa",false,null,null);
        Room r56 = new Room(606L,2,180,"Bristol Hotel","Odesa",false,null,null);
        Room r57 = new Room(607L,1,120,"Bristol Hotel","Odesa",false,null,null);
        Room r58 = new Room(608L,3,230,"Bristol Hotel","Odesa",false,null,null);
        Room r59 = new Room(609L,4,270,"Bristol Hotel","Odesa",false,null,null);
        Room r60 = new Room(610L,2,180,"Bristol Hotel","Odesa",false,null,null);
        //add rooms for Hotel #6 to set
        Set<Room> hotel06RoomSet = new HashSet<>();
        hotel06RoomSet.add(r51);
        hotel06RoomSet.add(r52);
        hotel06RoomSet.add(r53);
        hotel06RoomSet.add(r54);
        hotel06RoomSet.add(r55);
        hotel06RoomSet.add(r56);
        hotel06RoomSet.add(r57);
        hotel06RoomSet.add(r58);
        hotel06RoomSet.add(r59);
        hotel06RoomSet.add(r60);
        //set Hotel #6 rooms
        h06.setRooms(hotel06RoomSet);

        //Persist all hotels
        //Add all hotels to one set
        Set<Hotel> allHotels = new HashSet<>();
        allHotels.add(h01);
        allHotels.add(h02);
        allHotels.add(h03);
        allHotels.add(h04);
        allHotels.add(h05);
        allHotels.add(h06);
        //Save all hotels
        HotelDAOImpl.getInstance().saveAll(allHotels);
        //Get and print all saved hotels
        System.out.println("\n************ Print all Hotels ************");
        HotelDAOImpl.getInstance().getAll().forEach(System.out::println);

        //Persist all rooms
        //Add all rooms to one set
        Set<Room> allRooms = new HashSet<>();
        allRooms.addAll(hotel01RoomSet);
        allRooms.addAll(hotel02RoomSet);
        allRooms.addAll(hotel03RoomSet);
        allRooms.addAll(hotel04RoomSet);
        allRooms.addAll(hotel05RoomSet);
        allRooms.addAll(hotel06RoomSet);
        //Save all rooms
        RoomDAOImpl.getInstance().saveAll(allRooms);
        //Get and print all saved rooms
        System.out.println("\n************ Print all Rooms ************");
        RoomDAOImpl.getInstance().getAll().forEach(System.out::println);

        /***Test controller methods with authorized user***/

        //Test for registered current user
        //register user
        System.out.println("\n************ Register user ************");
        Controller.getInstance().registerUser(u01);
        //make user current
        System.out.println("\n************ Make registered user current ************");
        Controller.getInstance().switchCurrentUser(u01);

        /***find room***/
        System.out.println("\n************ Registered user: Find Room test #1 ************");
        Map<String, String> findRoomsMap1 = new HashMap<>();
        // Find Room r21 = new Room(301L,2,150,"Ibis","Lviv",false,null,null);
        findRoomsMap1.put("City", "Lviv");
        findRoomsMap1.put("Hotel", "Ibis");
        findRoomsMap1.put("Price", "150");
        findRoomsMap1.put("Persons", "2");
        findRoomsMap1.put("RoomId", "301");
        System.out.println(Controller.getInstance().findRoom(findRoomsMap1));

        System.out.println("\n************ Registered user: Find Room test #2 ************");
        Map<String, String> findRoomsMap2 = new HashMap<>();
        // Find Room r53 = new Room(603L,3,220,"Bristol Hotel","Odesa",false,null,null);
        findRoomsMap2.put("City", "Odesa");
        findRoomsMap2.put("Hotel", "Bristol Hotel");
        findRoomsMap2.put("Price", "180");
        System.out.println(Controller.getInstance().findRoom(findRoomsMap2));

        /***BookRoom***/
        System.out.println("\n************ Registered user: Book Room test ************");
        Controller.getInstance().bookRoom(301L, 1001L, 4L);
        //RoomDAOImpl.getInstance().getAll().stream().filter(r -> r.getRoomId() == 301L).forEach(System.out::println);

        /***Cancel Room Reservation***/
        System.out.println("\n************ Registered user: Cancel Room Reservation test ************");
        Controller.getInstance().cancelReservation(301L, 1001L, 4L);

        /***find Hotel by name***/
        System.out.println("\n************ Registered user: Find Hotel by name test ************");
        Controller.getInstance().findHotelByName("Bristol Hotel").stream().forEach(System.out::println);

        /***find Hotel by city***/
        System.out.println("\n************ Registered user: Find Hotel by city test ************");
        Controller.getInstance().findHotelByCity("Kiev").stream().forEach(System.out::println);




        /***Test controller methods with unauthorized user***/

        //Test for registered current user
        //make unregistered user current
        System.out.println("\n************ Make unregistered user current ************");
        Controller.getInstance().switchCurrentUser(u02);

        /***find room***/
        System.out.println("\n************ Unregistered user: Find Room test #1 ************");
        // Find Room r21 = new Room(301L,2,150,"Ibis","Lviv",false,null,null);
        System.out.println(Controller.getInstance().findRoom(findRoomsMap1));

        /***bookRoom***/
        System.out.println("\n************ Unregistered user: Book Room test ************");
        Controller.getInstance().bookRoom(301L, 1001L, 401L);
        //RoomDAOImpl.getInstance().getAll().stream().filter(r -> r.getRoomId() == 301L).forEach(System.out::println);

        /***cancel Room Reservation***/
        System.out.println("\n************ Unregistered user: Cancel Room Reservation test ************");
        Controller.getInstance().cancelReservation(301L, 1001L, 401L);

        /***find Hotel by name***/
        System.out.println("\n************ Unregistered user: Find Hotel by name test ************");
        Controller.getInstance().findHotelByName("Bristol Hotel").stream().forEach(System.out::println);

        /***find Hotel by city***/
        System.out.println("\n************ Unregistered user: Find Hotel by city test ************");
        Controller.getInstance().findHotelByCity("Kiev").stream().forEach(System.out::println);

    }
}
