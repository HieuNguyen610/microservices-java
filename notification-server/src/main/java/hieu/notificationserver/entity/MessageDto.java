package hieu.notificationserver.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String from;
    private String to;
    private String toName;
    private String subject;
    private String content;
}
