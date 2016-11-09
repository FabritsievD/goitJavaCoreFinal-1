package entities;

public class CurrentUser {

    private User user;

    /**
     * Class made singleton
     * */
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
