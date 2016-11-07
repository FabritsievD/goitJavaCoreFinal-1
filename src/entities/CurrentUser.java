package entities;

public class CurrentUser {
    User user;

    public CurrentUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
