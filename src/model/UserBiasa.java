package model;

public class UserBiasa extends User {

    public UserBiasa(String username, String email, String password){
        super(username, email, password, "user");
    }

    @Override
    public void dashboard(){
        System.out.println("Menu pemesanan tiket terbuka");
    }
}
