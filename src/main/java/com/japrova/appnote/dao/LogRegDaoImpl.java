package com.japrova.appnote.dao;

import com.japrova.appnote.dao.interfaces.LogRegInterface;
import com.japrova.appnote.models.TaskManager;
import com.japrova.appnote.models.User;
import com.japrova.appnote.persistence.PersistenceBd;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.Optional;

public class LogRegDaoImpl implements LogRegInterface {

    private EntityManager entityManager;

    public LogRegDaoImpl() {
        PersistenceBd persistence = new PersistenceBd();
        this.entityManager = persistence.getPersistence();
    }

    @Override
    public boolean createUser(User user) {

        try {
            TaskManager taskManager = new TaskManager();

            entityManager.getTransaction().begin();
            entityManager.persist(user);

            taskManager.setUser(user.getId());
            entityManager.persist(taskManager);

            entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace(); // Imprime la traza de la excepción para depuración
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<User> login(User user) {

        User userOptional = null;
        try {
            Query query = entityManager.createQuery("FROM User WHERE nickname = :nickname AND password = :password");
            query.setParameter("nickname", user.getNickname());
            query.setParameter("password", user.getPassword());

            userOptional = (User) query.getSingleResult();
        } catch (NoResultException n) {
            System.out.println(n.getCause());
        } finally {
            entityManager.close();
        }
        return Optional.ofNullable(userOptional);
    }

}
