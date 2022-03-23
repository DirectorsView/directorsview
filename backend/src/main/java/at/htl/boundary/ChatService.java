package at.htl.boundary;

import at.htl.control.ChatRepository;
import at.htl.control.MessageRepository;
import at.htl.entity.Chat;
import at.htl.entity.Message;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/chat")
@Produces(MediaType.APPLICATION_JSON)
public class ChatService {

    @Inject
    ChatRepository repository;

    @Inject
    MessageRepository messageRepository;

    @GET
    public List<Chat> getAll() {
        return repository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Chat chat) {
        try {
            return Response
                    .ok(repository.save(chat))
                    .build();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return Response
                    .status(400)
                    .entity("Token already used")
                    .build();
        }
    }

    @GET
    @Path("{id}")
    public Response getOne(@PathParam("id") Long id) {
        Chat chat = repository.findById(id);

        if (chat == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Chat not found")
                    .build();
        } else {
            return Response
                    .ok(chat)
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Chat put(@PathParam("id") long id, Chat chat) {
        Chat originalChat = repository.findById(id);

        if (originalChat != null) {
            originalChat.setAccount1(chat.getAccount1());
            originalChat.setAccount2(chat.getAccount2());
            originalChat.setToken(chat.getToken());
        }

        return originalChat;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Chat delete(@PathParam("id") long id) {
        Chat chat = repository.findById(id);
        chat.delete("id = " + id);
        return chat;
    }

    @GET
    @Path("/{id}/messages")
    public Response getMessages(@PathParam("id") long id) {
        if (repository.findById(id) == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Chat not found")
                    .build();
        }

        List<Message> messages = messageRepository.find("chat.id", id).list();

        return Response
                .ok(messages)
                .build();
    }
}
