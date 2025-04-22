package hieu.authserver.dto.response;

import hieu.authserver.entity.Account;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDto {
    private Long id;
    private String username;

    public static AccountDto from(Account user) {
        return AccountDto.builder()  // Corrected the reference to the builder
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}

