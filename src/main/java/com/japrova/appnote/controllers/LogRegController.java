package com.japrova.appnote.controllers;

import com.japrova.appnote.dao.LogRegDaoImpl;
import com.japrova.appnote.dao.interfaces.LogRegInterface;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;

import java.util.Optional;

public class LogRegController {

    public boolean createUser(String nickname, String password) {

        LogRegInterface logRegDaoImpl = new LogRegDaoImpl();

        return logRegDaoImpl.createUser(new User(nickname, password));
    }

    public boolean login(String nickname, String password) {

        LogRegInterface userDaoImpl = new LogRegDaoImpl();

        Optional<User> userOptional = userDaoImpl.login(new User(nickname, password));

        userOptional.ifPresent(u -> TaskManager.setUserStatic(userOptional.get().getId())); // Si esta presente almacena el objeto en la variable de alcance CLASE

        return userOptional.isPresent();

    }
}
