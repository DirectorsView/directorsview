package at.htl.boundary;

import at.htl.control.AccountRepository;
import at.htl.control.ChatRepository;
import at.htl.entity.Account;
import at.htl.entity.Chat;

import javax.inject.Inject;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    @Inject
    ChatRepository chatRepository;

    /**
     * @param jsonValue {
     *                  "email": "company@mail.com",
     *                  "password": "password"
     *                  }
     */

    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(JsonValue jsonValue) {
        if (jsonValue.getValueType().equals(JsonValue.ValueType.OBJECT)) {
            try {
                Account account = accountRepository
                        .find("email", jsonValue.asJsonObject().getString("email"))
                        .stream()
                        .findFirst()
                        .orElse(null);

                if (account == null) {
                    return Response.status(Response.Status.NOT_FOUND).build();
                }

                if (jsonValue.asJsonObject().getString("password").equals(account.getPassword())) {
                    return Response.ok(account).build();
                }

                return Response.status(Response.Status.UNAUTHORIZED).build();
            } catch (Exception e) {
                return Response.status(Response.Status.NOT_MODIFIED).build();
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("{id}/chats")
    public Response getChats(@PathParam("id") Long id) {

        if (accountRepository.findById(id) == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Account not found")
                    .build();
        }
        List<Chat> chat = chatRepository.find(String.format("account1 = %d or account2 = %d", id, id)).list();

        return Response
                .ok(chat)
                .build();
    }
}
