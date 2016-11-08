package dao;


import entities.Room;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RoomDAOImpl implements AbstractDAO<Room> {

    private Set<Room> rooms = new HashSet<>();
    private File fileRooms = new File("persist\\fileRooms.bin");
    private ObjectInputStream roomIputSt;
    private ObjectOutputStream roomOutputSt;

    /**
     * Class made singleton
     * */
    private static RoomDAOImpl instance = new RoomDAOImpl();

    public static RoomDAOImpl getInstance() {
        return instance;
    }

    private RoomDAOImpl() {
    }

    @Override
    public Room save(Room room) {
        /**
         * Method gets all available in persistent storage Rooms
         * append to the set (if not exists yet) given Room
         * and saves updated set of Rooms back to persistent storage
         * */
        this.rooms=getAll();
        if(this.rooms.contains(room)) this.rooms.remove(room);
        this.rooms.add(room);
        saveAll(this.rooms);
        this.rooms=getAll();
        return room;
    }

    @Override
    public void delete(Room room) {
        /**
         * Method gets all available in persistent storage Rooms
         * removes given in input Room from the set (if exists)
         * and saves remaining Rooms back to persistent storage
         * */
        rooms = getAll();
        if(rooms.contains(room)){
            rooms.remove(room);
        }
        saveAll(rooms);
        rooms=getAll();
    }

    @Override
    public void deleteAll(Set<Room> rooms) {
        /**
         * Method gets all available in persistent storage Rooms
         * removes all Rooms given in input set
         * and saves remaining Rooms back to persistent storage
         * */
        this.rooms = getAll();
        this.rooms.removeAll(rooms);
        saveAll(this.rooms);
        this.rooms=getAll();

    }

    @Override
    public void saveAll(Set<Room> rooms) {
        /**
         * Method gets all available in persistent storage Rooms
         * append given in input set of Rooms
         * and saves merged set of Rooms back to persistent storage
         * */
        if(rooms.size() > 0 && rooms != null) {
            this.rooms = rooms;
            try {
                roomOutputSt = new ObjectOutputStream(new FileOutputStream(fileRooms));
                roomOutputSt.writeObject(this.rooms);
                roomOutputSt.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("FileNotFoundException");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("IOException");
            }
        }
        this.rooms = getAll();
    }

    @Override
    public Set<Room> getAll() {
        /**
         * Method gets all available in persistent storage Rooms
         * */
        try{
            roomIputSt = new ObjectInputStream(new FileInputStream(fileRooms));
            rooms = (Set<Room>)roomIputSt.readObject();
            roomIputSt.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.println("IOException");
        }
        catch (ClassNotFoundException e){
            e.getStackTrace();
            System.err.println("ClassNotFoundException");
        }
        return rooms;
    }
}

