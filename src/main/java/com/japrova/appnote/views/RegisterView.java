package com.japrova.appnote.views;

import com.japrova.appnote.controllers.LogRegController;
import com.japrova.appnote.views.interfacesReusable.ReusableCodeInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterView extends JFrame implements ActionListener, ReusableCodeInterfaces {

    private JButton registerBtn;
    private JTextField nicknameField;
    private JPasswordField passwordField;
    private JPasswordField repeatPasswordField;
    private JPanel registerPanel;
    private JButton returnBtn;

    public RegisterView() {
        setContentPane(registerPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        initiateActions(this, Arrays.asList(registerBtn, returnBtn));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(registerBtn == e.getSource()) {

            String nickname = nicknameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String repeatPassword = String.valueOf(repeatPasswordField.getPassword());

            String defaultMessage = "Incorrect Fields";

            if(checkFields(nickname, password, repeatPassword)) {

                LogRegController logRegController = new LogRegController();
                defaultMessage = logRegController.createUser(nickname, password) ? "User successfully created" : "User could not register";
            }
            JOptionPane.showMessageDialog(this, defaultMessage);

        } else {
            LoginView loginView = new LoginView();
            this.dispose();
        }
    }
}
