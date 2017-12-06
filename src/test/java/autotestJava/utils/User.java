package autotestJava.utils;

import java.util.UUID;

public class User {
    private String userName;
    private String userMail;
    private String userWebsite;
    private String userNote;

    public User(){
        this.userName="PW "+ UUID.randomUUID().toString();
        this.userMail="PW@"+UUID.randomUUID().toString()+".pl";
        this.userNote="PW "+ UUID.randomUUID().toString();
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserNote() {

        return userNote;
    }

    public String getUserName() {

        return userName;
    }
}
