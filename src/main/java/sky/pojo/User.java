package sky.pojo;

import java.util.Date;

public class User {
    private String username;

    private String password;

    private Date regisTime;

    private String token;

    public User(String username, String password, Date regisTime, String token) {
        this.username = username;
        this.password = password;
        this.regisTime = regisTime;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}