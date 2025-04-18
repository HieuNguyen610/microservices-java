package hieu.notificationserver.service;

import hieu.notificationserver.entity.MessageDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(MessageDto messageDto) throws MessagingException;
}
