package com.japrova.appnote.views;

import javax.swing.*;

public class NewNoteView extends JFrame {
    private JButton noteBtn;
    private JTextArea paragraphText;
    private JTextField titleField;
    private JPanel newNotePanel;

    public NewNoteView() {
        setContentPane(newNotePanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
