package views;

import controllers.Controller;
import dao.HotelDAOImpl;
import dao.RoomDAOImpl;
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
        /***
         * Static method executes console menu where
         * user can do basic system operations: controller
         * functions as well as administration functions
         * to add entities
         * ***/
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("Please, make your choice: ");
            System.out.println("-> 1: Use system");
            System.out.println("-> 2: Administration");
            System.out.println("-> Any Key: Exit");
            String choise = sc.next();
            //Root switch menu
            switch (choise) {
                case "1":
                    System.out.println("Use System");
                    System.out.println("-> 1: Find Hotel by Name");
                    System.out.println("-> 2: Find Hotel by City");
                    System.out.println("-> 3: Book Room");
                    System.out.println("-> 4: Cancel Room Reservation");
                    System.out.println("-> 5: Find Room");
                    choise = sc.next();
                    //'Root' > 'System' menu starts when user input Root > 1
                    switch (choise) {
                        case "1":
                            //Controller > find hotel by name function execution on choice. Root > 1 > 1
                            System.out.print("Please, enter hotel name: ");
                            String hotelName = sc.next();
                            Controller.getInstance().findHotelByName(hotelName).forEach(System.out::println);
                            break;
                        case "2":
                            //Controller > find hotel by city function execution on choice. Root > 1 > 2
                            System.out.print("Please, enter hotel city: ");
                            String hotelCity = sc.next();
                            Controller.getInstance().findHotelByCity(hotelCity).forEach(System.out::println);
                            break;
                        case "3":
                            //Controller > book room. Root > 1 > 3,
                            // accepts all required parameters and executes Controller.bookRoom method
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
                            //Controller > cancel room reservation. Root > 1 > 4,
                            // accepts all required parameters and executes Controller.bookRoom method
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
                            //Controller > find room. Root > 1 > 5,
                            // accepts all required parameters and executes Controller.bookRoom method
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
                    //'Root' > 'Administration' menu starts when user input Root > 2
                    System.out.println("Administration");
                    System.out.println("-> 1: Hotels and Rooms");
                    System.out.println("-> 2: Users");
                    choise = sc.next();
                    switch (choise) {
                        case "1":
                            //'Root' > 'System' > 'Hotel and Rooms' menu starts when user input Root > 2 > 1
                            System.out.println("Administration > Hotel and Rooms");
                            System.out.println("-> 1: List Hotels");
                            System.out.println("-> 2: Add Hotel");
                            System.out.println("-> 3: Remove Hotel");
                            choise = sc.next();
                            switch (choise) {
                                case "1":
                                    //'Root' > 'Administration' > 'Hotel and Rooms' > 'List Hotels' item
                                    // call DAO method to select all hotels from persist and display in console
                                    System.out.println("Administration > Hotel and Rooms > List Hotels");
                                    HotelDAOImpl.getInstance().getAll().stream().forEach(System.out::println);
                                    break;
                                case "2":
                                    //'Root' > 'Administration' > 'Hotel and Rooms' > 'Add Hotel' item call,
                                    // accepts all parameters, call DAO method to save new hotel to persist
                                    System.out.println("Administration > Hotel and Rooms > Add Hotel");
                                    System.out.println("Adding hotel:");

                                    //Enter hotel parameters and save to variables
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

                                    //Enter room parameters (if required to add rooms) and save to variables
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

                                    //Save hotel using DAO method to file
                                    HotelDAOImpl.getInstance().save(new Hotel(hotelId,city,name,stars,rooms));
                                    //Save all rooms using DAO method to file
                                    RoomDAOImpl.getInstance().saveAll(rooms);
                                    break;

                                    case "3":
                                        //'Root' > 'Administration' > 'Hotel and Rooms' > 'Remove Hotel' item call,
                                        // accepts needed parameters, call DAO method to delete the hotel from persist
                                        System.out.println("Administration > Hotel and Rooms > RemoveHotel");
                                        System.out.println("Set Hotel ID:");
                                        Long hotelId1 = null;
                                        //Saves input parameters for hotel to be deleted
                                        try {
                                             hotelId1=Long.valueOf(sc.next());
                                        }catch (NumberFormatException e){
                                            System.out.println("Wrong input");
                                        }
                                        System.out.println("Enter City:");
                                        String city1 = sc.next();
                                        System.out.println("Enter Hotel name:");
                                        String name1 = sc.next();

                                        //Executes DAO method to delete the hotel
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
                                    //'Root' > 'Administration' > 'Hotel and Rooms' > 'List Users' item call,
                                    // call DAO method to get all users from file and print them all
                                    System.out.println("Administration > Users > List Users");
                                    UserDAOImpl.getInstance().getAll().stream().forEach(System.out::println);
                                    break;
                                case "2":
                                    //'Root' > 'Administration' > 'Hotel and Rooms' > 'Add new User' item call,
                                    // accepts all parameters, call DAO method to save new user to persist
                                    System.out.println("Administration > Users > Add new User");

                                    //Generate new user ID
                                    Long id = UserDAOImpl.getInstance().getAll().size()+1L;
                                    //Saves new user parameters to variables
                                    System.out.println("Enter First Name");
                                    String firstName = sc.next();
                                    System.out.println("Enter Last Name");
                                    String lastName = sc.next();

                                    //Executes DAO method to add/save the user
                                    UserDAOImpl.getInstance().save(new User(id,firstName,lastName));
                                    break;
                                case "3":
                                    //'Root' > 'Administration' > 'Users' > 'Delete User' item call,
                                    // accepts needed parameters, call DAO method to delete the user from persist
                                    System.out.println("Administration > Users > Delete User");
                                    System.out.println("Enter User's ID");
                                    Long id1= null;

                                    //Saves input parameters for user to be deleted
                                    try {
                                        id1 = Long.valueOf(sc.next());
                                    } catch (NumberFormatException e){
                                        System.out.println("Wrong input");
                                    }
                                    System.out.println("Enter First Name");
                                    String firstName1 = sc.next();
                                    System.out.println("Enter Last Name");
                                    String lastName1 = sc.next();

                                    //Executes DAO method to delete the user
                                    UserDAOImpl.getInstance().delete(new User(id1,firstName1,lastName1));
                                    break;

                                default:break;
                            }

                    }
                default:
                    //Set flag to default to exit from the loop on any key
                    flag = false;
                    break;
            }

        }
    }
}
