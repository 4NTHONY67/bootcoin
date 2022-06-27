package com.nttdata.bootcoin.service.impl;

import com.nttdata.bootcoin.model.AccountModel;
import com.nttdata.bootcoin.repository.AccountRepository;
import com.nttdata.bootcoin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  AccountRepository accountRepository;

  @Override
  public List<AccountModel> findAll() {
    return accountRepository.findAll();
  }

  @Override
  public AccountModel create(AccountModel account) {
    return accountRepository.save(account);
  }

  @Override
  public AccountModel update(AccountModel account) {
    return accountRepository.save(account);
  }

  @Override
  public void delete(String dni) {
    accountRepository.deleteById(dni);
  }

  @Override
  public AccountModel findByDoc(String doc) {
    return accountRepository.findByDoc(doc);
  }
}
