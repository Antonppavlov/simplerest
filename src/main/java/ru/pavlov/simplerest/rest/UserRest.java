package ru.pavlov.simplerest.rest;

import ru.pavlov.simplerest.entity.User;
import ru.pavlov.simplerest.registrator.UserRegistrator;
import ru.pavlov.simplerest.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/user")
public class UserRest {

    @Inject
    private Logger logger;


    @Inject
    private UserRegistrator userRegistrator;

    @Inject
    private UserRepository userRepository;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        logger.info("getAll User");
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(int id) {
        logger.info("User getById: " + id);
        return userRepository.getById(id);
    }

}
