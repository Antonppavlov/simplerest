package ru.pavlov.simplerest.rest;

import ru.pavlov.simplerest.entity.Message;
import ru.pavlov.simplerest.registrator.MessageRegistrator;
import ru.pavlov.simplerest.repository.MessageRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/message")
public class MessageRest {

    @Inject
    private Logger logger;


    @Inject
    private MessageRegistrator messageRegistrator;

    @Inject
    private MessageRepository messageRepository;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll() {
        logger.info("getAll Message");
        return messageRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(int id) {
        logger.info("Message getById: " + id);
        return messageRepository.getById(id);
    }

}
