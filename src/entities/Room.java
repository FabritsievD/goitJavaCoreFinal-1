package entities;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable {
    private Long roomId;
    private Integer persons;
    private Integer price;
    private Hotel hotel;
    private String city;
    private boolean isReserved;
    private Date dateAvalibleFrom;
    private User userReserved;

    public Room() {
    }

    public Room(Long roomId, Integer persons, Integer price, Hotel hotel, String city, boolean isReserved, Date dateAvalibleFrom, User userReserved) {
        this.roomId = roomId;
        this.persons = persons;
        this.price = price;
        this.hotel = hotel;
        this.city = city;
        this.isReserved = isReserved;
        this.dateAvalibleFrom = dateAvalibleFrom;
        this.userReserved = userReserved;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateAvalibleFrom(Date dateAvalibleFrom) {
        this.dateAvalibleFrom = dateAvalibleFrom;
    }

    public void setIsReserved(boolean reserved) {isReserved = reserved;}

    public void setUserReserved(User userReserved) {this.userReserved = userReserved;}

    public String getCity() {
        return city;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public User getUserReserved() {
        return userReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != null ? !roomId.equals(room.roomId) : room.roomId == null) return false;
        if (persons != null ? !persons.equals(room.persons) : room.persons == null) return false;
        if (price != null ? !price.equals(room.price) : room.price == null) return false;
        if (dateAvalibleFrom != null ? !(dateAvalibleFrom.getTime()>=room.dateAvalibleFrom.getTime()) : room.dateAvalibleFrom ==null )return false;
        return city != null ? city.equals(room.city) : room.city != null;

    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", persons=" + persons +
                ", price=" + price +
                ", hotel='" + hotel + '\'' +
                ", city='" + city + '\'' +
                ", isReserved=" + isReserved +
                ", dateAvalibleFrom=" + dateAvalibleFrom +
                ", userReserved=" + userReserved +
                '}';
    }
}
