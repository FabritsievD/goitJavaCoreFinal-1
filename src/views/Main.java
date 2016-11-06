package views;

import dao.HotelDAOImpl;
import entities.Hotel;

public class Main {
    public static void main(String[] args) {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        Hotel h1 = new Hotel(1,"Kiev","Hilton", 5, null);
        hotelDAO.save(h1);
        System.out.println(hotelDAO.getList());

    }
}
