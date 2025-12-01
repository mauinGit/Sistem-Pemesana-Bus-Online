package view;

import javax.swing.*;
import java.awt.GridLayout;
import service.Bus;
import java.util.List;


public class DaftarBus extends JFrame {
    
    public DaftarBus(){
        setTitle("Daftar Bus");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2,2,2));

        Bus service = new Bus();
        List<String[]> daftarBus = service.GetBus();

        for(String[] bus : daftarBus){

            JLabel nama = new JLabel(bus[1] + " ("+bus[2]+" seat)");
            JButton btn = new JButton("Lihat Kursi");

            int idBus = Integer.parseInt(bus[0]);

            btn.addActionListener(e -> {
                dispose();
                new KursiView(idBus);
            });

            add(nama);
            add(btn);
        }

        setVisible(true);
    }
}
