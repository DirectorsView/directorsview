package at.htl.boundary;

import at.htl.control.AccountRepository;
import at.htl.control.ChatRepository;
import at.htl.control.MessageRepository;
import at.htl.entity.Account;
import at.htl.entity.Chat;
import at.htl.entity.Message;
import io.smallrye.common.annotation.NonBlocking;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat-ws/{token}/{accountId}")
@ApplicationScoped
public class ChatSocket {

    Map<String, List<Session>> sessions = new ConcurrentHashMap<>();

    @Inject
    MessageRepository messageRepository;

    @Inject
    AccountRepository accountRepository;

    @Inject
    ChatRepository chatRepository;

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token, @PathParam("accountId") Long accountId) {
        if (sessions.get(token) == null) {
            sessions.put(token, List.of(session));
        } else {
            sessions.get(token).add(session);
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("token") String token, @PathParam("accountId") Long accountId) {
        Session sessionToRemove = sessions
                .get(token)
                .stream()
                .filter(s -> s.getId().equals(session.getId()))
                .findFirst()
                .orElse(null);

        sessions.get(token).remove(sessionToRemove);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("token") String token, @PathParam("accountId") Long accountId) {
        System.out.println(accountRepository);

        sessions.get(token).forEach(session -> {
            Account account = accountRepository.findById(accountId);
            Chat chat = chatRepository.find("token", token).firstResult();
            Message messageObject = messageRepository.save(new Message(account, message, LocalDate.now(), chat));
            session.getAsyncRemote().sendObject(messageObject);
        });
    }
}
