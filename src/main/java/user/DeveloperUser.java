package user;

import user.IUser;

public class DeveloperUser extends IUser {

    public DeveloperUser(String name, String email, String phoneNumber, String slackId) {
        super(name, email, phoneNumber, slackId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeveloperUser{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
