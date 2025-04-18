package hieu.accountserver.service;

import hieu.accountserver.dao.AccountDto;

import java.util.List;

public interface AccountService {
    void add(AccountDto accountDto);
    void update(AccountDto accountDto);
    void updatePassword(AccountDto accountDto);
    void delete(Long id);
    List<AccountDto> getAll();
    AccountDto getOne(Long id);
}
