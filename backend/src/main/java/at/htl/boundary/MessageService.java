package at.htl.boundary;

import at.htl.control.MessageRepository;
import at.htl.entity.Message;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageService {

    @Inject
    MessageRepository messageRepository;

    @GET
    public List<Message> getAll() {
        return messageRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message post(Message message) {
        return messageRepository.save(message);
    }

    @GET
    @Path("{id}")
    public Message getOne(@PathParam("id") Long id) {
        return messageRepository.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Message put(@PathParam("id") long id, Message message) {
        Message originalMessage = messageRepository.findById(id);

        if (originalMessage != null) {
            originalMessage.setSource(message.getSource());
            originalMessage.setContent(message.getContent());
            originalMessage.setTime(message.getTime());
            originalMessage.setChat(message.getChat());
        }

        return originalMessage;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Message delete(@PathParam("id") long id) {
        Message message = messageRepository.findById(id);
        message.delete("id = " + id);
        return message;
    }

}