package com.japrova.appnote.dao;

import com.japrova.appnote.dao.interfaces.ManagementInterface;
import com.japrova.appnote.models.Task;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;
import com.japrova.appnote.persistence.PersistenceBd;
import jakarta.persistence.*;

import java.util.List;

public class ManagementDaoImpl implements ManagementInterface {

    private EntityManager entityManager;

    public ManagementDaoImpl() {
        PersistenceBd persistence = new PersistenceBd();
        this.entityManager = persistence.getPersistence();
    }

    @Override
    public List<Task> getTasks(Integer idUser) {

        List<Task> tasks = null;
        try {
            Query query = entityManager.createQuery("FROM Task WHERE taskManager = :idTaskManager");
            query.setParameter("idTaskManager", getTaskManager(idUser));

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

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {

            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteTask(Integer idTask) {
        return false;
    }

    @Override
    public Integer getTaskManager(Integer idUser) {

        TaskManager taskManager = null;
        try {
            TypedQuery<TaskManager> typedQuery = entityManager.createQuery("FROM TaskManager WHERE idUser = :idUser", TaskManager.class);
            typedQuery.setParameter("idUser", idUser);

            taskManager = typedQuery.getSingleResult();

        } catch (NoResultException nre) {
            throw new NoResultException("Cause: " + nre.getCause());
        }
        return taskManager.getTaskManagerId();
    }
}
