package com.japrova.appnote.models;


import jakarta.persistence.*;

@Entity
@Table(name = "taskmanager")
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTaskManager")
    private Integer taskManagerId;

    @Column(name = "idUser")
    private Integer idUser;

    private static Integer userStatic;

    public TaskManager() {
    }

    public int getTaskManagerId() {
        return taskManagerId;
    }

    public void setTaskManagerId(int taskManagerId) {
        this.taskManagerId = taskManagerId;
    }

    public Integer getUser() {
        return idUser;
    }

    public void setUser(Integer idUser) {
        this.idUser = idUser;
    }

    public static Integer getUserStatic() {
        return userStatic;
    }

    public static void setUserStatic(Integer userStatic) {
        TaskManager.userStatic = userStatic;
    }
}