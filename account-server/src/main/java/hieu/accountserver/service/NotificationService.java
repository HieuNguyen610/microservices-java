package hieu.accountserver.service;

import hieu.accountserver.dao.MessageDto;
import hieu.accountserver.service.impl.NotificationServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-server", url = "http://localhost:9083", fallback = NotificationServiceImpl.class)
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDto messageDto);
}
