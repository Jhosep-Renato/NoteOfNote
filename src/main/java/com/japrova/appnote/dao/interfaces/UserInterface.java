package com.japrova.appnote.dao.interfaces;


import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;

import java.util.Optional;

public interface UserInterface {

    boolean createUser(User user);

    Optional<User> login(User user);

    TaskManager getUser(User user);
}
