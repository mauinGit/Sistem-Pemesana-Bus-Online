package service;

import konfigurasi.Config;
import java.sql.*;

public class Kursi {
    public ResultSet getSeats(int idBus){
            try {
                Connection conn = Config.getConnection();

                PreparedStatement pst = conn.prepareStatement(
                    "SELECT * FROM kursi WHERE id_bus=? ORDER BY id_kursi"
                );

                pst.setInt(1, idBus);
                return pst.executeQuery();

            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        public void book(int idBus, String noKursi){
            try {
                Connection conn = Config.getConnection();

                PreparedStatement pst = conn.prepareStatement(
                    "UPDATE kursi SET status='booked' WHERE id_bus=? AND no_kursi=?"
                );

                pst.setInt(1, idBus);
                pst.setString(2, noKursi);
                pst.executeUpdate();

            } catch(Exception e){
                e.printStackTrace();
            }
        }
}
