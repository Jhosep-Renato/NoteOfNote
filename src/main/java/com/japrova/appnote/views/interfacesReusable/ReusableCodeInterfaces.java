package com.japrova.appnote.views.interfacesReusable;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public interface ReusableCodeInterfaces {

    default void initiateActions(ActionListener actionListener, List<JButton> components) {
        components.forEach(c -> {
            c.addActionListener(actionListener);
        });
    }

    default boolean checkFields(String nickname, String password) { // validar si no es vacio

        if(!nickname.isEmpty() && !password.isEmpty()) {
            return true;
        }
        return false;
    }

    default boolean checkFields(String nickname, String password, String repeatPassword) { // valida password no vacio y password iguales

        boolean validation = false;

        if(checkFields(nickname, password) && !repeatPassword.isEmpty()) {

            validation = password.equals(repeatPassword);
        }
        return validation;
    }
}
