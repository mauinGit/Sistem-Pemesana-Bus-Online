package view;

import javax.swing.*;
import service.Autentikasi;

public class Register extends JFrame {

    private JTextField userField, emailField;
    private JPasswordField passField;
    private Autentikasi auth;

    public Register() {

        auth = new Autentikasi();
        setTitle("Register");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50,30,100,30);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150,30,150,30);
        add(userField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50,70,100,30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150,70,150,30);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50,110,100,30);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150,110,150,30);
        add(passField);

        JButton regBtn = new JButton("Register");
        regBtn.setBounds(150,160,100,30);
        add(regBtn);

        regBtn.addActionListener(e -> register());

        setVisible(true);
    }

    private void register() {
        auth.register(
                userField.getText(),
                emailField.getText(),
                new String(passField.getPassword())
        );

        JOptionPane.showMessageDialog(this, "Akun berhasil dibuat!");
        dispose();
    }
}
