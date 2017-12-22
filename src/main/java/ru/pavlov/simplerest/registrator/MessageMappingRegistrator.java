package ru.pavlov.simplerest.registrator;

import ru.pavlov.simplerest.entity.MessageMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageMappingRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(MessageMapping messageMapping) {
        logger.info("Create MessageMapping:" + messageMapping);
        entityManager.merge(messageMapping);
    }

    public void update(MessageMapping messageMapping) {
        logger.info("Update MessageMapping:" + messageMapping);
        entityManager.merge(messageMapping);
    }

    public void delete(MessageMapping messageMapping) {
        logger.info("Delete MessageMapping:" + messageMapping);
        entityManager.remove(messageMapping);
    }
}
