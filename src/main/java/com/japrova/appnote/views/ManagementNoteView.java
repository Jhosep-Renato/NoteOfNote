package com.japrova.appnote.views;

import com.japrova.appnote.controllers.ManagementTaskController;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.views.interfacesReusable.ReusableCodeInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class ManagementNoteView extends JFrame implements ActionListener, ReusableCodeInterfaces {
    private JButton addNoteButton;
    private JPanel managementPanel;
    private JTextPane notePane;
    private JPanel panelBtn;
    private TaskManager taskManager;

    public ManagementNoteView() {
        setContentPane(managementPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        initiateActions(this, Collections.singletonList(addNoteButton));

        ManagementTaskController managementTaskController = new ManagementTaskController();
        managementTaskController.getTasks(TaskManager.getUserStatic());

        System.out.println("El id del TaskManager del usuario: " + TaskManager.getUserStatic());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(addNoteButton == e.getSource()) {
            NewNoteView newNoteView = new NewNoteView();
        }
    }
}
