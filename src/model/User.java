package model;

public abstract class User {
    protected String username;
    protected String email;
    protected String password;
    protected String role;

    public User(String username, String email, String password, String role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public abstract void dashboard();

    public String getRole(){
        return this.role;
    }

    public String getUsername(){
        return this.username;
    }
}