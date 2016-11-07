package entities;

public class CurrentUser {
    User user;
    private static CurrentUser instance = new CurrentUser();

    private CurrentUser() {
    }

    public static CurrentUser getInstance(){
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
