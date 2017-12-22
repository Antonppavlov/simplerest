package ru.pavlov.simplerest.repository;


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
public class UserRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<User> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        return entityManager.createQuery(query).getResultList();
    }

    public User getById(int id) {
        logger.info("Get User by id: " + id);
        return entityManager.find(User.class, id);
    }

    public List<User> getByFromUserNickName(String nickName) {
        logger.info("Get User by nickName: " + nickName);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> element = query.from(User.class);
        query.select(element).where(criteriaBuilder.equal(element.get("nick_name"), nickName));

        return entityManager.createQuery(query).getResultList();
    }
}
