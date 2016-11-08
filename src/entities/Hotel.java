package entities;

import java.io.Serializable;
import java.util.Set;

public class Hotel implements Serializable{
    private Long hotelId;
    private String city;
    private String name;
    private Integer stars;
    private Set<Room> rooms;

    public Hotel(Long hotelId, String city, String name, Integer stars, Set<Room> rooms) {
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

    public Set<Room> getRooms() {
        return rooms;
    }

    public int getStars() {
        return stars;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (hotelId != hotel.hotelId) return false;
        if (!city.equals(hotel.city)) return false;
        return name.equals(hotel.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (hotelId ^ (hotelId >>> 32));
        result = 31 * result + city.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }
}
