package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.models.NotificationMessage;
import com.example.sidiayapi.repositories.UsersRepository;
import com.example.sidiayapi.utils.Logger;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;
    private final UsersRepository usersRepository;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging, UsersRepository usersRepository) {
        this.firebaseMessaging = firebaseMessaging;
        this.usersRepository = usersRepository;
    }

    public void notifyNewTicketStatus(Tickets ticket, Integer oldTicketStatusId) {
        List<Users> subscribers = usersRepository.findSubscribersByTicketId(ticket.getId());
        Logger.log("Found " + subscribers.size() + " subscribers to " + ticket.getId() + " ticket");
        for (Users user : subscribers) {
            if (!user.getFcmToken().isBlank()) {
                try {
                    String oldTicketStatus = StatusesEnum.getByValue(oldTicketStatusId).label;
                    String newTicketStatus = StatusesEnum.getByValue(ticket.getStatus()).label;

                    Map<String, String> data = new HashMap<>();
                    String title = "Статус заявки изменился";
                    String body = "Номер заявки: " + ticket.getId() + ". " + oldTicketStatus + " -> " + newTicketStatus;
                    sendNotificationByToken(new NotificationMessage(user.getFcmToken(), title, body, data));
                } catch (Exception ignored) {
                }
            }
        }
    }

    public String sendNotificationByToken(NotificationMessage notificationMessage) {
        Notification notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .build();

        Message message = Message
                .builder()
                .setToken(notificationMessage.getRecipientToken())
                .setNotification(notification)
                .putAllData(notificationMessage.getData())
                .build();

        try {
            firebaseMessaging.send(message);
            return "Success sending notification";
        } catch (FirebaseMessagingException e) {
            Logger.log(e.getMessage());
            return "Error sending notification";
        }
    }
}
