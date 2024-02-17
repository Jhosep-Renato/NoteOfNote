package com.japrova.appnote.controllers;

import com.japrova.appnote.dao.LogRegDaoImpl;
import com.japrova.appnote.dao.interfaces.UserInterface;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;

import java.util.Optional;

public class LogRegController {

    public boolean createUser(String nickname, String password) {

        UserInterface logRegDaoImpl = new LogRegDaoImpl();

        return logRegDaoImpl.createUser(new User(nickname, password));
    }

    public boolean login(String nickname, String password) {

        UserInterface userDaoImpl = new LogRegDaoImpl();

        Optional<User> userOptional = userDaoImpl.login(new User(nickname, password));

        userOptional.ifPresent(TaskManager::setUserStatic); // Si esta presente almacena el objeto en la variable de alcance CLASE

        return userOptional.isPresent();

    }

    public TaskManager getUser(User user) {

        UserInterface userDaoImpl = new LogRegDaoImpl();

        return userDaoImpl.getUser(user);
    }
}
