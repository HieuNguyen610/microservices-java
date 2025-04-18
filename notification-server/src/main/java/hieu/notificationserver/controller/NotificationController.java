package hieu.notificationserver.controller;

import hieu.notificationserver.entity.MessageDto;
import hieu.notificationserver.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final EmailService emailService;

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDto messageDto) throws MessagingException {
        emailService.sendEmail(messageDto);
    }
}
