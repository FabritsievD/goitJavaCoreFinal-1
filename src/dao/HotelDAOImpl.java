package dao;

import entities.Hotel;

import java.io.*;
import java.util.Set;

public class HotelDAOImpl implements AbstractDAO<Hotel> {


    private static HotelDAOImpl instance = new HotelDAOImpl();
    private Set<Hotel> hotels;
    private File fileHotels = new File("persist\\fileHotels.bin");
    private ObjectOutputStream hotelOs;
    private ObjectInputStream hotelIs;


    public static HotelDAOImpl getInstance(){
        return instance;
    }

    private HotelDAOImpl() {
    }

    @Override
    public Hotel save(Hotel hotel) {
        if(hotel!=null) {
            hotels = getAll();
            if (!hotels.contains(hotel)) {
                hotels.add(hotel);
            }
            saveAll(hotels);
        }
        return hotel;
    }

    @Override
    public void delete(Hotel hotel) {
        if(hotel!=null) {
            hotels = getAll();
            hotels.remove(hotel);
        }
        saveAll(hotels);
    }

    @Override
    public void deleteAll(Set<Hotel> hotels) {
        this.hotels = getAll();
        if(hotels.size() > 0 && hotels != null) {
            this.hotels.removeAll(hotels);
        }
        saveAll(this.hotels);
    }

    @Override
    public void saveAll(Set<Hotel> hotels) {
        this.hotels = getAll();
        if(hotels.size() > 0 && hotels != null) {
            this.hotels.addAll(hotels);
            try {
                hotelOs = new ObjectOutputStream(new FileOutputStream(fileHotels));
                hotelOs.writeObject(this.hotels);
                hotelOs.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("IO Exception");
            }
        }
    }

    @Override
    public Set<Hotel> getAll() {
        try {
            hotelIs = new ObjectInputStream(new FileInputStream(fileHotels));
            hotels = (Set<Hotel>) hotelIs.readObject();
            hotelIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hotels;
    }
}