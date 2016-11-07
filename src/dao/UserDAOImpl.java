package dao;

import entities.User;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements AbstractDAO<User> {

    private static UserDAOImpl instance = new UserDAOImpl();
    private Set<User> users;
    private File fileUsers = new File("persist\\fileUsers.bin");
    private ObjectOutputStream userOs;
    private ObjectInputStream userIs;

    public static UserDAOImpl getInstance(){
        return instance;
    }

    private UserDAOImpl() {
    }

    @Override
    public User save(User user) {
        if(user!=null) {
            users = getAll();
            users.add(user);
            saveAll(users);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        if(user!=null) {
            users = getAll();
            if (users.contains(user)) {
                users.remove(user);
            }
            saveAll(users);
        }
    }

    @Override
    public void deleteAll(Set<User> users) {
        this.users = getAll();
        if(users.size() > 0 && users != null) {
            this.users.removeAll(users);
        }
        saveAll(this.users);
    }

    @Override
    public void saveAll(Set<User> users) {
        this.users = getAll();
        if(users.size() > 0 && users != null) {
            this.users.addAll(users);
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
    }

    @Override
    public Set<User> getAll() {
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
