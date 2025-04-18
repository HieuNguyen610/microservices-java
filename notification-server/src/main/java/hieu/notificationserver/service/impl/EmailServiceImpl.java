package hieu.notificationserver.service.impl;

import hieu.notificationserver.entity.MessageDto;
import hieu.notificationserver.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    @Override
    public void sendEmail(MessageDto messageDto) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

        Context context = new Context();
        context.setVariable("name", messageDto.getToName());
        context.setVariable("content", messageDto.getContent());
        String html = templateEngine.process("welcome-email", context);

        helper.setTo(messageDto.getTo());
        helper.setText(html, true);
        helper.setSubject(messageDto.getSubject());
        helper.setFrom(messageDto.getFrom());
        javaMailSender.send(message);
        log.info("Send mail successfully");
    }
}
