package service;

import konfigurasi.Config;
import java.sql.*;

public class Pesanan {

    public void simpanPemesanan(int idBus, String noKursi, String nama, String telp, int harga){
        try {
            Connection conn = Config.getConnection();

            String sql = "INSERT INTO pemesanan " + "(id_bus, no_kursi, nama, telp, harga) VALUES (?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, idBus);
            pst.setString(2, noKursi);
            pst.setString(3, nama);
            pst.setString(4, telp);
            pst.setInt(5, harga);

            pst.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}