package hieu.accountserver.controller;

import hieu.accountserver.dao.AccountDto;
import hieu.accountserver.dao.MessageDto;
import hieu.accountserver.dao.StatisticDto;
import hieu.accountserver.service.AccountService;
import hieu.accountserver.service.NotificationService;
import hieu.accountserver.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final NotificationService notificationService;
    private final StatisticService statisticService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody AccountDto accountDto) {
        accountService.add(accountDto);

        statisticService.create(StatisticDto.builder()
                        .message("Create user successfully")
                        .createdDate(new Date())
                .build());
        notificationService.sendNotification(MessageDto.builder()
                        .to("hieunm2@vnext.vn")
                        .content("Create user notification")
                        .subject("Create user successfully")
                        .from("harrynguyen610@gmail.com")
                .build());
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
