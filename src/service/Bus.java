package service;

import konfigurasi.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bus {

    public void generateKursi(int idBus, int jumlahSeat){
        try {
            Connection conn = Config.getConnection();

            String[] baris = {"A","B","C","D","E","F","G","H"};
            int seatCreated = 0;

            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO kursi(id_bus, no_kursi, status) VALUES (?, ?, 'kosong')"
            );

            for(int i = 0; i < baris.length; i++){
                for(int j = 1; j <= 4; j++){

                    seatCreated++;
                    if(seatCreated > jumlahSeat) break;

                    pst.setInt(1, idBus);
                    pst.setString(2, baris[i] + j);
                    pst.executeUpdate();
                }
            }

            System.out.println("Generate kursi selesai untuk bus " + idBus);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String[]> GetBus() {
        List<String[]> list = new ArrayList<>();

        try {
            Connection conn = Config.getConnection();
            String sql = "SELECT * FROM bus";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                list.add(new String[]{
                        rs.getString("id_bus"),
                        rs.getString("nama_bus"),
                        rs.getString("seat")
                });
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
    
    public static void main(String[] args) {

        Bus b = new Bus();
        b.generateKursi(1, 32);
        b.generateKursi(2, 20);

        System.out.println("SELESAI SEMUA!");
    }
}
