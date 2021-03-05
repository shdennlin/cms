package org.shdennlin.cms.controller;


import org.shdennlin.cms.model.Account;
import org.shdennlin.cms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        account = accountService.createAccount(account);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        return ResponseEntity.created(location).body(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> replaceAccoutn(
            @PathVariable("id") Long id, @RequestBody Account account) {
        account = accountService.replaceAccount(id, account);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
