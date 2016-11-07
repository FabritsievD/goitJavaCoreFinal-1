package entities;

import java.util.Date;

public class Room {
    private Long roomId;
    private Integer persons;
    private Integer price;
    private String hotel;
    private String city;
    private boolean userReserved;
    private Date dateAvalibleFrom;

    public Room() {
    }

    public Room(long roomId, int persons, int price, String hotel, String city, boolean userReserved, Date dateAvalibleFrom) {
        this.roomId = roomId;
        this.persons = persons;
        this.price = price;
        this.hotel = hotel;
        this.city = city;
        this.userReserved = userReserved;
        this.dateAvalibleFrom = dateAvalibleFrom;
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

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateAvalibleFrom(Date dateAvalibleFrom) {
        this.dateAvalibleFrom = dateAvalibleFrom;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != null ? !roomId.equals(room.roomId) : room.roomId == null) return false;
        if (persons != null ? !persons.equals(room.persons) : room.persons == null) return false;
        if (price != null ? !price.equals(room.price) : room.price == null) return false;
        if (hotel != null ? !hotel.equals(room.hotel) : room.hotel == null) return false;
        if (dateAvalibleFrom != null ? !(dateAvalibleFrom.getTime()>=room.dateAvalibleFrom.getTime()) : room.dateAvalibleFrom ==null )return false;
        return city != null ? city.equals(room.city) : room.city != null;

    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (persons != null ? persons.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
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
                ", userReserved=" + userReserved +
                ", dateAvalibleFrom=" + dateAvalibleFrom +
                '}';
    }
}
