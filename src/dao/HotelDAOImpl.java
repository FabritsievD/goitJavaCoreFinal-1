package dao;

import entities.Hotel;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class HotelDAOImpl implements AbstractDAO<Hotel> {


    private Set<Hotel> hotels = new HashSet<>();
    private File fileHotels = new File("persist\\fileHotels.bin");
    private ObjectOutputStream hotelOs;
    private ObjectInputStream hotelIs;

    /**
     * Class made singleton
     * */
    private static HotelDAOImpl instance = new HotelDAOImpl();

    public static HotelDAOImpl getInstance(){
        return instance;
    }

    private HotelDAOImpl() {
    }

    @Override
    public Hotel save(Hotel hotel) {
        /**
         * Method gets all available in persistent storage Hotels
         * append to the set (if not exists yet) given Hotel
         * and saves updated set of Hotels back to persistent storage
         * */
        if(hotel!=null) {
            hotels = getAll();
            hotels.add(hotel);
            saveAll(hotels);
        }
        hotels = getAll();
        return hotel;
    }

    @Override
    public void delete(Hotel hotel) {
        /**
         * Method gets all available in persistent storage Hotels
         * removes given in input Hotel from the set (if exists)
         * and saves remaining Hotels back to persistent storage
         * */
        if(hotel!=null) {
            hotels = getAll();
            hotels.remove(hotel);
        }
        saveAll(hotels);
        hotels = getAll();
    }

    @Override
    public void deleteAll(Set<Hotel> hotels) {
        /**
         * Method gets all available in persistent storage Hotels
         * removes all Hotels given in input set
         * and saves remaining Hotels back to persistent storage
         * */
        this.hotels = getAll();
        if(hotels.size() > 0 && hotels != null) {
            this.hotels.removeAll(hotels);
        }
        saveAll(this.hotels);
        this.hotels = getAll();
    }

    @Override
    public void saveAll(Set<Hotel> hotels) {
        /**
         * Method gets all available in persistent storage Hotels
         * append given in input set of Hotels
         * and saves merged set of Hotels back to persistent storage
         * */
        if(hotels.size() > 0 && hotels != null) {
            this.hotels = hotels;
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
        this.hotels = getAll();
    }

    @Override
    public Set<Hotel> getAll() {
        /**
         * Method gets all available in persistent storage Hotels
         * */
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