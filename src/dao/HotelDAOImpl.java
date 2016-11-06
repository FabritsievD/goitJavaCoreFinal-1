package dao;

import entities.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements AbstractDAO<Hotel> {

    List<Hotel> hotels = new ArrayList<>();
    File fileHotels = new File("fileHotels.bin");
    ObjectOutputStream hotelOs;
    ObjectInputStream hotelIs;


    @Override
    public Hotel save(Hotel hotel) {
        hotels = getList();
        if(!hotels.contains(hotel)) {
            hotels.add(hotel);
            saveAll(hotels);
        }
        return hotel;
    }

    @Override
    public void delete(Hotel hotel) {
        hotels = getList();
        if(hotels.contains(hotel)) {
            hotels.remove(hotel);
            saveAll(hotels);
        }

    }

    @Override
    public void deleteAll(List<Hotel> hotels) {
        this.hotels.removeAll(hotels);
        saveAll(this.hotels);
    }

    @Override
    public void saveAll(List<Hotel> hotels) {
        this.hotels = hotels;
        try {
            hotelOs = new ObjectOutputStream(new FileOutputStream(fileHotels));
            hotelOs.writeObject(hotels);
            hotelOs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO Exception");
        }

    }

    @Override
    public List<Hotel> getList() {
        try {
            hotelIs = new ObjectInputStream(new FileInputStream(fileHotels));
            hotels = (List<Hotel>) hotelIs.readObject();
            hotelIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hotels;
    }
}