package views;

import controllers.Controller;
import dao.HotelDAOImpl;
import dao.UserDAOImpl;
import entities.Hotel;
import entities.Room;
import entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleMenu {
    private static ConsoleMenu instance = new ConsoleMenu();

    public static ConsoleMenu getInstance() {
        return instance;
    }

    private ConsoleMenu() {
    }
    public static void consoleMenu() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("Please, make your choice: ");
            System.out.println("-> 1: Use system");
            System.out.println("-> 2: Administration");
            System.out.println("-> Any Key: Exit");
            String choise = sc.next();
            switch (choise) {
                case "1":
                    System.out.println("Use System");
                    System.out.println("-> 1: Find Hotel by Name");
                    System.out.println("-> 2: Find Hotel by City");
                    System.out.println("-> 3: Book Room");
                    System.out.println("-> 4: Cancel Room Reservation");
                    System.out.println("-> 5: Find Room");
                    choise = sc.next();
                    switch (choise) {
                        case "1":
                            System.out.print("Please, enter hotel name: ");
                            String hotelName = sc.next();
                            Controller.getInstance().findHotelByName(hotelName).forEach(System.out::println);
                            break;
                        case "2":
                            System.out.print("Please, enter hotel city: ");
                            String hotelCity = sc.next();
                            Controller.getInstance().findHotelByCity(hotelCity).forEach(System.out::println);
                            break;
                        case "3":
                            try {
                                System.out.println("Book Room: ");
                                System.out.println("Enter Hotel ID: ");
                                Long hotelId = Long.parseLong(sc.next());
                                System.out.println("Enter Room ID: ");
                                Long roomId = Long.parseLong(sc.next());
                                System.out.println("Enter User ID: ");
                                Long userId = Long.parseLong(sc.next());
                                Controller.getInstance().bookRoom(roomId, userId, hotelId);
                                }
                                catch (NumberFormatException e){
                                    System.err.println("Wrong input");
                                }
                            break;
                        case "4":
                            try {
                                System.out.println("Cancel Room Reservation: ");
                                System.out.println("Enter Hotel ID: ");
                                Long hotelId2 = Long.parseLong(sc.next());
                                System.out.println("Enter Room ID: ");
                                Long roomId2 = Long.parseLong(sc.next());
                                System.out.println("Enter User ID: ");
                                Long userId2 = Long.parseLong(sc.next());
                                Controller.getInstance().cancelReservation(roomId2, userId2, hotelId2);
                                }
                                catch (NumberFormatException e){
                                    System.err.println("Wrong input");
                                }
                            break;
                        case "5":
                            System.out.println("Find Room: ");
                            Map<String, String> params = new HashMap<>();
                            System.out.println("Set city? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("City", sc.next());
                            System.out.println("Set hotel? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("Hotel", sc.next());
                            System.out.println("Set price? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("Price", sc.next());
                            System.out.println("Set persons? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("Persons", sc.next());
                            System.out.println("Set room id? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("RoomId", sc.next());
                            System.out.println("Set from date (format dd.MM.yyyy)? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("From", sc.next());
                            Controller.getInstance().findRoom(params).forEach(System.out::println);
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Administration");
                    System.out.println("-> 1: Hotels and Rooms");
                    System.out.println("-> 2: Users");
                    choise = sc.next();
                    switch (choise) {
                        case "1":
                            System.out.println("Administration > Hotel and Rooms");
                            System.out.println("-> 1: List Hotels");
                            System.out.println("-> 2: Add Hotel");
                            System.out.println("-> 3: Remove Hotel");
                            choise = sc.next();
                            switch (choise) {
                                case "1":
                                    System.out.println("Administration > Hotel and Rooms > List Hotels");
                                    HotelDAOImpl.getInstance().getAll().stream().forEach(System.out::println);
                                    break;
                                case "2":
                                    System.out.println("Administration > Hotel and Rooms > Add Hotel");
                                    System.out.println("Adding hotel:");

                                    System.out.println("Set Hotel ID? (Y|N):");
                                    Long hotelId = null;
                                    if(sc.next().equals("Y")) {
                                        System.out.println("Enter Hotel ID:");
                                        try {
                                            hotelId = Long.parseLong(sc.next());
                                        }
                                        catch (NumberFormatException e){
                                            System.out.println("Wrong input");
                                        }
                                    }

                                    System.out.println("Set City? (Y|N):");
                                    String city = null;
                                    if(sc.next().equals("Y")){
                                        System.out.println("Enter City:");
                                        city = sc.next();
                                    }
                                    System.out.println("Enter Hotel name? (Y|N):");
                                    String name = null;
                                    if(sc.next().equals("Y")){
                                        System.out.println("Enter Hotel name:");
                                         name = sc.next();
                                    }
                                    System.out.println("Enter number of stars? (Y|N)");
                                    Integer stars = null;
                                    if(sc.next().equals("Y")){
                                        System.out.println("Enter number of stars:");
                                        try{
                                         stars=Integer.parseInt(sc.next());
                                        }
                                        catch (NumberFormatException e){
                                            System.out.println("Wrong input");
                                        }
                                    }

                                    System.out.println("Add rooms? (Y|N)");
                                    Set<Room> rooms = new HashSet<>();
                                    if(sc.next().equals("Y")){
                                        boolean flag1 = true;
                                        while (flag1) {
                                            Room room = new Room();
                                            System.out.println("Set city? (Y|N): ");
                                            if (sc.next().equals("Y")) room.setCity(sc.next());
                                            System.out.println("Set hotel? (Y|N): ");
                                            if (sc.next().equals("Y")) room.setHotel(sc.next());
                                            System.out.println("Set price? (Y|N): ");
                                            if (sc.next().equals("Y"))
                                                try {
                                                    room.setPrice(Integer.valueOf(sc.next()));
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Wrong input");
                                                }
                                            System.out.println("Set persons? (Y|N): ");
                                            if (sc.next().equals("Y"))
                                                try {
                                                    room.setPersons(Integer.valueOf(sc.next()));
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Wrong input");
                                                }
                                            System.out.println("Set room id? (Y|N): ");
                                            if (sc.next().equals("Y"))
                                                try {
                                                    room.setRoomId(Long.valueOf(sc.next()));
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Wrong input");
                                                }
                                            System.out.println("Set from date (format dd.MM.yyyy)? (Y|N): ");
                                            if (sc.next().equals("Y")){
                                                String tmp = sc.next();
                                                SimpleDateFormat format = new SimpleDateFormat();
                                                format.applyPattern("dd.MM.yyyy");
                                                try {
                                                    Date date = format.parse(tmp);
                                                    room.setDateAvalibleFrom(date);
                                                } catch (ParseException e) {
                                                    System.out.println("Wrong date format");
                                                }
                                            }
                                            System.out.println("Set IsReserved? (Y|N)");
                                            if(sc.next().equals("Y")){
                                                System.out.println("If room reserved enter \"true\"");
                                                room.setIsReserved(Boolean.parseBoolean(sc.next()));
                                            }

                                            rooms.add(room);

                                            System.out.println("Want to add once more room? (Y|N)");
                                            if(sc.next().equals("Y")) continue;
                                            flag1=false;
                                        }

                                        }
                                    else{
                                        rooms = null;
                                    }

                                    HotelDAOImpl.getInstance().save(new Hotel(hotelId,city,name,stars,rooms));
                                    break;

                                    case "3":
                                        System.out.println("Administration > Hotel and Rooms > RemoveHotel");
                                        System.out.println("Set Hotel ID:");
                                        Long hotelId1 = null;
                                        try {
                                             hotelId1=Long.valueOf(sc.next());
                                        }catch (NumberFormatException e){
                                            System.out.println("Wrong input");
                                        }
                                        System.out.println("Enter City:");
                                        String city1 = sc.next();
                                        System.out.println("Enter Hotel name:");
                                        String name1 = sc.next();

                                        HotelDAOImpl.getInstance().delete(new Hotel(hotelId1,city1,name1,null,null));
                                        break;

                                    default:
                                    break;
                            }

                        case "2":
                            System.out.println("Administration > Users");
                            System.out.println("-> 1: User's List ");
                            System.out.println("-> 2: Add new User");
                            System.out.println("-> 3: Delete User");
                            choise=sc.next();
                            switch (choise){
                                case "1":
                                    System.out.println("Administration > Users > User's List");
                                    UserDAOImpl.getInstance().getAll().stream().forEach(System.out::println);
                                    break;
                                case "2":
                                    System.out.println("Administration > Users > Add new User");
                                    Long id = UserDAOImpl.getInstance().getAll().size()+1L;
                                    System.out.println("Enter First Name");
                                    String firstName = sc.next();
                                    System.out.println("Enter Last Name");
                                    String lastName = sc.next();
                                    UserDAOImpl.getInstance().save(new User(id,firstName,lastName));
                                    break;
                                case "3":
                                    System.out.println("Administration > Users > Delete User");
                                    System.out.println("Enter User's ID");
                                    Long id1= null;
                                    try {
                                        id1 = Long.valueOf(sc.next());
                                    } catch (NumberFormatException e){
                                        System.out.println("Wrong input");
                                    }
                                    System.out.println("Enter First Name");
                                    String firstName1 = sc.next();
                                    System.out.println("Enter Last Name");
                                    String lastName1 = sc.next();
                                    UserDAOImpl.getInstance().delete(new User(id1,firstName1,lastName1));
                                    break;

                                default:break;
                            }

                    }
                default:
                    flag = false;
                    break;
            }

        }
    }
}
