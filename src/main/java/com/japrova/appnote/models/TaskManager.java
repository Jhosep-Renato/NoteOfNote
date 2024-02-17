package com.japrova.appnote.models;


import jakarta.persistence.*;

@Entity
@Table(name = "taskmanager")
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTaskManager")
    private int taskManagerId;

    @Column(name = "user")
    private User user;

    private static User userStatic;

    public TaskManager() {
    }

    public int getTaskManagerId() {
        return taskManagerId;
    }

    public void setTaskManagerId(int taskManagerId) {
        this.taskManagerId = taskManagerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static User getUserStatic() {
        return userStatic;
    }

    public static void setUserStatic(User userStatic) {
        TaskManager.userStatic = userStatic;
    }
}