package com.japrova.appnote.dao;

import com.japrova.appnote.dao.interfaces.ManagementInterface;
import com.japrova.appnote.models.Task;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;
import com.japrova.appnote.persistence.PersistenceBd;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ManagementDaoImpl implements ManagementInterface {

    private EntityManager entityManager;

    public ManagementDaoImpl() {
        PersistenceBd persistence = new PersistenceBd();
        this.entityManager = persistence.getPersistence();
    }

    @Override
    public List<Task> getTasks(Integer idTaskManager) {

        List<Task> tasks = null;
        try {
            Query query = entityManager.createQuery("FROM Task WHERE taskManager = :idTaskManager");
            query.setParameter("idTaskManager", idTaskManager);

            tasks = (List<Task>) query.getResultList();

        } catch (NoResultException nre) {
            throw new NoResultException("Cause: " + nre.getCause());
        } finally {
            entityManager.close();
        }
        return tasks;
    }

    @Override
    public boolean registerTask(Task task) {
        return false;
    }

    @Override
    public boolean deleteTask(Integer idTask) {
        return false;
    }

    public User getUser(Integer idUser) {
        return null;
    }
}
