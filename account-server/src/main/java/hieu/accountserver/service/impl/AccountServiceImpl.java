package hieu.accountserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import hieu.accountserver.dao.AccountDto;
import hieu.accountserver.entity.Account;
import hieu.accountserver.repository.AccountRepository;
import hieu.accountserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j(topic = "Account-service")
public class AccountServiceImpl implements AccountService {

    private final ObjectMapper objectMapper;
    private final AccountRepository accountRepository;

    private AccountDto convertDto(Account account) {
        return objectMapper.convertValue(account, AccountDto.class);
    }

    private List<AccountDto> convertDtos(List<Account> accounts) {
        return accounts.stream().map(this::convertDto).collect(Collectors.toList());
    }

    private Account convertEntity(AccountDto dto) {
        return objectMapper.convertValue(dto, Account.class);
    }

    @Override
    public void add(AccountDto accountDto) {
        log.info("Create account..");
        Account newAccount = Account.builder()
                .name(accountDto.getName())
                .username(accountDto.getUsername())
                .password(accountDto.getPassword())
                .build();
        accountRepository.save(newAccount);
    }

    @Override
    public void update(AccountDto accountDto) {
        log.info("Update account");
        Account account = accountRepository.findById(accountDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        account.setName(accountDto.getName());
        account.setPassword(accountDto.getPassword());
        account.setRoles(accountDto.getRoles());
        accountRepository.save(account);
    }

    @Override
    public void updatePassword(AccountDto accountDto) {

    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found"));
        accountRepository.delete(account);
    }

    @Override
    public List<AccountDto> getAll() {
        log.info("Get all accounts info");
        List<Account> accounts = accountRepository.findAll();
        return convertDtos(accounts);
    }

    @Override
    public AccountDto getOne(Long id) {
        log.info("Get account info by id = " + id);
        return convertDto(accountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found")));
    }
}
