package view;

import javax.swing.*;
import service.Autentikasi;
import view.DaftarBus;

public class Login extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private Autentikasi auth;

    public Login() {

        auth = new Autentikasi();
        setTitle("Login");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50,30,100,30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150,30,150,30);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50,70,100,30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(50,130,100,30);
        add(loginBtn);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(200,130,100,30);
        add(registerBtn);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> new Register());

        setVisible(true);
    }

    private void login() {
        String email = emailField.getText();
        String pass = new String(passwordField.getPassword());

        if(auth.login(email, pass)) {
            JOptionPane.showMessageDialog(this, "Login sukses!");
            dispose();
            new DaftarBus(); 
        } else {
            JOptionPane.showMessageDialog(this, "Email/Password salah!");
        }
    }
}