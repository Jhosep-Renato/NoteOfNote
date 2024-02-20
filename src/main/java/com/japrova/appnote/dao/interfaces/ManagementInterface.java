package com.japrova.appnote.dao.interfaces;

import com.japrova.appnote.models.Task;

import java.util.List;

public interface ManagementInterface {

    List<Task> getTasks(Integer idTaskManager);

    boolean registerTask(Task task);

    boolean deleteTask(Integer idTask);

    Integer getTaskManager(Integer idUser);

}
