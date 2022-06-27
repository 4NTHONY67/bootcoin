package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.model.RateModel;
import com.nttdata.bootcoin.model.TransactionModel;

import java.util.List;

public interface TransactionService {
  List<TransactionModel> findAll();
  TransactionModel create(TransactionModel transaction);
  TransactionModel update(TransactionModel transaction);
  void delete(String id);
  TransactionModel confirmarTransaccion(String numero);

  TransactionModel findById(String numero);
}
