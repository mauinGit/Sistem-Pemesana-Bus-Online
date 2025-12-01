package view;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import service.Kursi;
import service.Pesanan;

public class KursiView extends JFrame {

    private int idBus;
    private Pesanan pesanan = new Pesanan();
    private Kursi kursi = new Kursi();

    public KursiView(int idBus) {
        this.idBus = idBus;

        setTitle("Pilih Kursi Bus");
        setSize(500,400);
        setLayout(new BorderLayout());

        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(0,5,10,10));
        add(seatPanel, BorderLayout.CENTER);

        loadSeats(seatPanel);

        JButton backBtn = new JButton("Kembali");
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.addActionListener(e -> {
            dispose();
            new DaftarBus();
        });
        add(backBtn, BorderLayout.SOUTH);

        setVisible(true);
    }


    private void loadSeats(JPanel seatPanel){
        try {
            ResultSet rs = kursi.getSeats(idBus);
            int counter = 0;

            while(rs.next()){
                counter++;

                String nomor = rs.getString("no_kursi");
                String status = rs.getString("status");

                JButton btn = new JButton(nomor);

                if(status.equals("booked")){
                    btn.setBackground(Color.RED);
                    btn.setEnabled(false);
                } else {
                    btn.setBackground(Color.GREEN);
                }

                btn.addActionListener(e -> openPemesanan(nomor, btn));

                // Layout bus 2-2
                if(counter % 4 == 1 || counter % 4 == 2){
                    seatPanel.add(btn);
                }

                if(counter % 4 == 2){
                    seatPanel.add(new JLabel("")); // space aisle
                }

                if(counter % 4 == 3 || counter % 4 == 0){
                    seatPanel.add(btn);
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private int getHarga(){
        if(idBus == 1) return 15000;
        if(idBus == 2) return 10000;
        return 0;
    }


    private void openPemesanan(String noKursi, JButton btn){

        JTextField nama = new JTextField();
        JTextField telp = new JTextField();
        JTextField harga = new JTextField(String.valueOf(getHarga()));
        harga.setEditable(false);

        Object[] message = {
                "Nama:", nama,
                "No Telp:", telp,
                "Harga tiket:", harga
        };

        int option = JOptionPane.showConfirmDialog(
                this, message, "Form Pemesanan",
                JOptionPane.OK_CANCEL_OPTION
        );

        if(option == JOptionPane.OK_OPTION){

            pesanan.simpanPemesanan(
                    idBus,
                    noKursi,
                    nama.getText(),
                    telp.getText(),
                    Integer.parseInt(harga.getText())
            );

            kursi.book(idBus, noKursi);

            btn.setBackground(Color.RED);
            btn.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Pemesanan berhasil!");
        }
    }
}