package sky.pojo;

import java.util.Date;

public class User {
    private String username;

    private String password;

    private Date regisTime;

    public User(String username, String password, Date regisTime) {
        this.username = username;
        this.password = password;
        this.regisTime = regisTime;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegisTime() {
        return regisTime;
    }

    public void setRegisTime(Date regisTime) {
        this.regisTime = regisTime;
    }
}