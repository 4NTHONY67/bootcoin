package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.model.AccountModel;
import com.nttdata.bootcoin.model.RateModel;
import com.nttdata.bootcoin.model.TransactionModel;

import java.util.List;

public interface AccountService {
  List<AccountModel> findAll();
  AccountModel create(AccountModel account);
  AccountModel update(AccountModel account);
  void delete(String dni);

  AccountModel findByDoc(String doc);
}
