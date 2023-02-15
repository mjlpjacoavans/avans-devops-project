package main.java.user;

public abstract class IUser {
    String name;
    String email;
    String phoneNumber;

    public IUser(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
