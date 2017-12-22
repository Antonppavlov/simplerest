package ru.pavlov.simplerest.registrator;

import ru.pavlov.simplerest.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class UserRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(User user) {
        logger.info("Create User:" + user);
        entityManager.merge(user);
    }

    public void update(User user) {
        logger.info("Update User:" + user);
        entityManager.merge(user);
    }

    public void delete(User user) {
        logger.info("Delete User:" + user);
        entityManager.remove(user);
    }
}
