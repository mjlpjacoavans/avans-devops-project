package main.java.user;

public class TesterUser extends IUser{

    public TesterUser(String name, String email, String phoneNumber, String slackId) {
        super(name, email, phoneNumber, slackId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TesterUser{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
