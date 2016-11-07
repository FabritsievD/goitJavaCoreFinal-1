package dao;


import entities.Room;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RoomDAOImpl implements AbstractDAO<Room> {

    private static RoomDAOImpl instance = new RoomDAOImpl();
    private Set<Room> rooms = new HashSet<>();
    private File fileRooms = new File("persist\\fileRooms.bin");
    private ObjectInputStream roomIputSt;
    private ObjectOutputStream roomOutputSt;

    public static RoomDAOImpl getInstance() {
        return instance;
    }

    @Override
    public Room save(Room room) {
        rooms= getAll();
        if(!rooms.contains(room)){
            rooms.add(room);
        }
        return room;
    }

    @Override
    public void delete(Room room) {
        rooms = getAll();
        if(rooms.contains(room)){
            rooms.remove(room);
        }
        saveAll(rooms);

    }

    @Override
    public void deleteAll(Set<Room> rooms) {
        this.rooms = getAll();
        this.rooms.removeAll(rooms);
        saveAll(this.rooms);

    }

    @Override
    public void saveAll(Set<Room> rooms) {
        this.rooms = getAll();
        if(rooms.size()>0){
            this.rooms.addAll(rooms);
        }

        try {
            roomOutputSt = new ObjectOutputStream(new FileOutputStream(fileRooms));
            roomOutputSt.writeObject(this.rooms);
            roomOutputSt.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.err.println("FileNotFoundException");
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.println("IOException");
        }

    }

    @Override
    public Set<Room> getAll() {
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

