package ru.pavlov.simplerest.rest;

import ru.pavlov.simplerest.entity.MessageMapping;
import ru.pavlov.simplerest.registrator.MessageMappingRegistrator;
import ru.pavlov.simplerest.repository.MessageMappingRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/message_mapping")
public class MessageMappingRest {

    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator messageMappingRegistrator;

    @Inject
    private MessageMappingRepository messageMappingRepository;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll() {
        logger.info("getAll MessageMapping");
        return messageMappingRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(int id) {
        logger.info("MessageMapping getById: " + id);
        return messageMappingRepository.getById(id);
    }
}
