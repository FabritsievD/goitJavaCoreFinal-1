package entities;

import java.util.List;

public class Hotel {
    private long hotelId;
    private String city;
    private String name;
    private int stars;
    private List<Room> rooms;

    public Hotel(long hotelId, String city, String name, int stars, List<Room> rooms) {
        this.hotelId = hotelId;
        this.city = city;
        this.name = name;
        this.stars = stars;
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

    public int getStars() {
        return stars;
    }
}
