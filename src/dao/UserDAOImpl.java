package dao;

import entities.User;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements AbstractDAO<User> {

    private Set<User> users = new HashSet<>();
    private File fileUsers = new File("persist\\fileUsers.bin");
    private ObjectOutputStream userOs;
    private ObjectInputStream userIs;

    /**
     * Class made singleton
     * */
    private static UserDAOImpl instance = new UserDAOImpl();

    public static UserDAOImpl getInstance(){
        return instance;
    }

    private UserDAOImpl() {
    }

    @Override
    public User save(User user) {
        /**
         * Method gets all available in persistent storage Users
         * append to the set (if not exists yet) given User
         * and saves updated set of Users back to persistent storage
         * */
        if(user!=null) {
            users = getAll();
            users.add(user);
            saveAll(users);
        }
        this.users = getAll();
        return user;
    }

    @Override
    public void delete(User user) {
        /**
         * Method gets all available in persistent storage Users
         * removes given in input User from the set (if exists)
         * and saves remaining Users back to persistent storage
         * */
        if(user!=null) {
            users = getAll();
            if (users.contains(user)) {
                users.remove(user);
            }
            saveAll(users);
        }
        this.users = getAll();
    }

    @Override
    public void deleteAll(Set<User> users) {
        /**
         * Method gets all available in persistent storage Users
         * removes all Users given in input set
         * and saves remaining Users back to persistent storage
         * */
        this.users = getAll();
        if(users.size() > 0 && users != null) {
            this.users.removeAll(users);
        }
        saveAll(this.users);
        this.users = getAll();
    }

    @Override
    public void saveAll(Set<User> users) {
        /**
         * Method gets all available in persistent storage Users
         * append given in input set of Users
         * and saves merged set of Users back to persistent storage
         * */
        if(users.size() > 0 && users != null) {
            this.users = users;
            try {
                userOs = new ObjectOutputStream(new FileOutputStream(fileUsers));
                userOs.writeObject(this.users);
                userOs.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("IO Exception");
            }
        }
        this.users = getAll();
    }

    @Override
    public Set<User> getAll() {
        /**
         * Method gets all available in persistent storage Users
         * */
        try {
            userIs = new ObjectInputStream(new FileInputStream(fileUsers));
            users = (Set<User>) userIs.readObject();
            userIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
