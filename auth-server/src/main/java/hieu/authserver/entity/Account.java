package hieu.authserver.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String password;
    String username;

    @ElementCollection
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "account_id"))
    Set<String> roles;
}
