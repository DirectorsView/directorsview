package at.htl.boundary;

import at.htl.control.MessageRepository;
import at.htl.entity.Message;
import at.htl.entity.Project;

import javax.inject.Inject;
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
}
