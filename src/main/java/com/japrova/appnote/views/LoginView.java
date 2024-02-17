package com.japrova.appnote.views;

import com.japrova.appnote.controllers.LogRegController;
import com.japrova.appnote.views.interfacesReusable.ReusableCodeInterfaces;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginView extends JFrame implements ActionListener, ReusableCodeInterfaces {
    private JPasswordField passwordField;
    private JTextField nicknameField;
    private JButton logBtn;
    private JPanel loginPanel;
    private JButton newUserBtn;


    public LoginView() {
        setContentPane(loginPanel);
        setResizable(false);
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initiateActions(this, Arrays.asList(logBtn, newUserBtn));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(logBtn == e.getSource()) {

            String password = String.valueOf(passwordField.getPassword());
            String nickname = nicknameField.getText();
            String message = "";

            if(checkFields(nickname, password)) {

                LogRegController logRegController = new LogRegController();
                boolean validation = logRegController.login(nickname, password);

                message = (validation) ? "Welcome: " + nickname : "User not found";

                JOptionPane.showMessageDialog(this, message);

            } else {

                JOptionPane.showMessageDialog(this, "Field not filled in");
            }

            if(message.contains("Welcome")) {
                ManagementNoteView managementNote = new ManagementNoteView();
                this.dispose();
            }

        }
        else {
            RegisterView registerView = new RegisterView();
            this.dispose();
        }
    }

}
