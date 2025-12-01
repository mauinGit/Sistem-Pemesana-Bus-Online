package service;
import java.sql.*;
import konfigurasi.Config;

public class Autentikasi {
    public boolean login(String email, String password) {
        try {
            Connection conn = Config.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean register(String username, String email, String password){
        try {
            Connection conn = Config.getConnection();
            String sql = "INSERT INTO users(username,email,password,role) VALUES(?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, "user");

            pst.executeUpdate();
            return true;

        } catch (Exception e){
            return false;
        }
    }
}
