package views;

import dao.HotelDAOImpl;
import entities.Hotel;

public class Main {
    public static void main(String[] args) {
        Hotel h1 = new Hotel(1,"Kiev","Hilton", 5, null);
        HotelDAOImpl.getInstance().save(h1);
        System.out.println(HotelDAOImpl.getInstance().getAll());

    }
}
