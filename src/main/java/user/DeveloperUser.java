package main.java.user;

public class DeveloperUser extends IUser{
    public DeveloperUser(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeveloperUser{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
