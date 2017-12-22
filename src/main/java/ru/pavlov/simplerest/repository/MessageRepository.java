package ru.pavlov.simplerest.repository;


import ru.pavlov.simplerest.entity.Message;
import ru.pavlov.simplerest.entity.Message;
import ru.pavlov.simplerest.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<Message> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);

        return entityManager.createQuery(query).getResultList();
    }

    public Message getById(int id) {
        logger.info("Get message by id: " + id);
        return entityManager.find(Message.class, id);
    }

}
