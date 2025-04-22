package hieu.authserver.service;

import hieu.authserver.entity.Account;
import hieu.authserver.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
