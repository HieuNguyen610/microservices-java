package hieu.accountserver.controller;

import hieu.accountserver.dao.AccountDto;
import hieu.accountserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody AccountDto accountDto) {
        accountService.add(accountDto);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        AccountDto accountDto = accountService.getOne(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody AccountDto accountDto) {
        accountService.update(accountDto);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<AccountDto> accountDtos = accountService.getAll();
        return ResponseEntity.ok(accountDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        accountService.delete(id);
        return ResponseEntity.ok("Delete successfully account id = " + id);
    }

    @PutMapping("/password")
    public ResponseEntity<?> updatePassword(@RequestBody AccountDto accountDto) {
        accountService.updatePassword(accountDto);
        return ResponseEntity.ok(accountDto);
    }
}
