package hieu.authserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hieu.authserver.dto.response.UserDto;
import hieu.authserver.entity.User;
import hieu.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    public UserDto saveUser(User user) {
        User savedUser = User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
        return convertToDto(userRepository.save(savedUser));
    }

    public UserDto findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return convertToDto(user);
    }

    private User convertToEntity(UserDto userDto) {
        return objectMapper.convertValue(userDto, User.class);
    }

    private UserDto convertToDto(User user) {
        return objectMapper.convertValue(user, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
