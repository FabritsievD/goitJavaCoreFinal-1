package entities;

import java.util.List;

public class Hotel {
    private long hotelId;
    private String city;
    private String name;
    private List<Room> rooms;

    public Hotel(long hotelId, String city, String name, List<Room> rooms) {
        this.hotelId = hotelId;
        this.city = city;
        this.name = name;
        this.rooms = rooms;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
