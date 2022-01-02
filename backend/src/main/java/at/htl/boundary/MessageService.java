package at.htl.boundary;

import at.htl.control.MessageRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageService {

    @Inject
    MessageRepository messageRepository;
}
