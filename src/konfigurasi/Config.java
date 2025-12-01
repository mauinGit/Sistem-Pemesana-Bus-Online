package konfigurasi;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Config{
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/uas_pbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultSet;


    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.err.println("Koneksi Database Berhasil");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Koneksi Database Gagal");
        }
        return connect;
    }
}
