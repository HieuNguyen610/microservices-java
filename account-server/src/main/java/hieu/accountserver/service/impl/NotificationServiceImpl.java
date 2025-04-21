package hieu.accountserver.service.impl;

import hieu.accountserver.dao.MessageDto;
import hieu.accountserver.service.NotificationService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(MessageDto messageDto) {
        log.info("Notification service is not available");
    }
}
