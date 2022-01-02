package at.htl.boundary;

import at.htl.control.MessageRepository;
import at.htl.entity.Message;
import at.htl.entity.Project;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
