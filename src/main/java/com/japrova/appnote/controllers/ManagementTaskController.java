package com.japrova.appnote.controllers;

import com.japrova.appnote.dao.ManagementDaoImpl;
import com.japrova.appnote.models.Task;

import java.util.List;

public class ManagementTaskController {

    public List<Task> getTasks(Integer idTaskManager) {

        ManagementDaoImpl managementDao = new ManagementDaoImpl();
        List<Task> listTask = managementDao.getTasks(idTaskManager);

        return listTask;
    }
}
