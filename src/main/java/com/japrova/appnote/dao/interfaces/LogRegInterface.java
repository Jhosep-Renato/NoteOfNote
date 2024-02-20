package com.japrova.appnote.dao.interfaces;

import com.japrova.appnote.models.User;
import java.util.Optional;

public interface LogRegInterface {

    boolean createUser(User user);

    Optional<User> login(User user);
}
