package hieu.authserver.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String userId;
    private String accessToken;
    private String refreshToken;
}
