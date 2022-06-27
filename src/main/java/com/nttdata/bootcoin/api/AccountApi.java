package com.nttdata.bootcoin.api;

import com.nttdata.bootcoin.model.AccountModel;
import com.nttdata.bootcoin.model.TransactionModel;
import com.nttdata.bootcoin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "account")
public class AccountApi {
  @Autowired
  private AccountService accountService;

  @GetMapping
  public List<AccountModel> findAll() {
    return accountService.findAll();
  }

  @PostMapping
  public ResponseEntity<AccountModel> create(@RequestBody AccountModel account) {
    AccountModel response = accountService.create(account);
    return new ResponseEntity<AccountModel>(response, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<AccountModel> update(@RequestBody AccountModel account) {
    AccountModel response = accountService.update(account);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    accountService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{doc}")
  public ResponseEntity<AccountModel> findByDoc(@PathVariable("doc") String doc) {
    AccountModel response = accountService.findByDoc(doc);
    return new ResponseEntity<AccountModel>(response, HttpStatus.FOUND);
  }
}