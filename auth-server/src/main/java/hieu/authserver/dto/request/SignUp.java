package hieu.authserver.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    private String username;
    private String password;
}
