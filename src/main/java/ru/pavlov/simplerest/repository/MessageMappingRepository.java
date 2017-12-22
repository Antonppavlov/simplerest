package ru.pavlov.simplerest.repository;


import ru.pavlov.simplerest.entity.MessageMapping;
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
public class MessageMappingRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<MessageMapping> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> query = criteriaBuilder.createQuery(MessageMapping.class);

        return entityManager.createQuery(query).getResultList();
    }

    public MessageMapping getById(int id) {
        logger.info("Get MessageMapping by id: " + id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromUserId(User user) {
        logger.info("Get MessageMapping by UserId: " + user);

        //поиск по списку и поиск MessageMapping в которых from_user_id =  user
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> query = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = query.from(MessageMapping.class);
        query.select(element).where(criteriaBuilder.equal(element.get("from_user_id"), user));

        return entityManager.createQuery(query).getResultList();
    }
}
