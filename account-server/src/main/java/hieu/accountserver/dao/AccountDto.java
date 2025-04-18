package hieu.accountserver.dao;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AccountDto {
    Long id;

    String name;
    String password;
    String username;
    Set<String> roles;
}
