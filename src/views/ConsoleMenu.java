package views;

import controllers.Controller;
import dao.HotelDAOImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
                            System.out.println("Book Room: ");
                            System.out.println("Enter Hotel ID: ");
                            Long hotelId = Long.parseLong(sc.next());
                            System.out.println("Enter Room ID: ");
                            Long roomId = Long.parseLong(sc.next());
                            System.out.println("Enter User ID: ");
                            Long userId = Long.parseLong(sc.next());
                            Controller.getInstance().bookRoom(roomId,userId,hotelId);
                            break;
                        case "4":
                            System.out.println("Cancel Room Reservation: ");
                            System.out.println("Enter Hotel ID: ");
                            Long hotelId2 = Long.parseLong(sc.next());
                            System.out.println("Enter Room ID: ");
                            Long roomId2 = Long.parseLong(sc.next());
                            System.out.println("Enter User ID: ");
                            Long userId2 = Long.parseLong(sc.next());
                            Controller.getInstance().cancelReservation(roomId2,userId2,hotelId2);
                            break;
                        case "5":
                            System.out.println("Find Room: ");
                            Map<String, String> params = new HashMap<>();
                            System.out.println("Set city? (Y|N): ");
                            if(sc.next().equals("Y")) params.put("City", sc.next());
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

                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                default:
                    flag = false;
                    break;
            }

        }
    }
}
