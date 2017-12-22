package ru.pavlov.simplerest.registrator;

import ru.pavlov.simplerest.entity.Message;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(Message message) {
        logger.info("Create Message:" + message);
        entityManager.merge(message);
    }

    public void update(Message message) {
        logger.info("Update Message:" + message);
        entityManager.merge(message);
    }

    public void delete(Message message) {
        logger.info("Delete Message:" + message);
        entityManager.remove(message);
    }
}
