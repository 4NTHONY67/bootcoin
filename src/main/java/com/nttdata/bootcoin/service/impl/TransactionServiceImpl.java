package com.nttdata.bootcoin.service.impl;

import com.nttdata.bootcoin.model.AccountModel;
import com.nttdata.bootcoin.model.RateModel;
import com.nttdata.bootcoin.model.TransactionModel;
import com.nttdata.bootcoin.repository.AccountRepository;
import com.nttdata.bootcoin.repository.TransactionRepository;
import com.nttdata.bootcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  AccountRepository accountRepository;

  @Override
  public List<TransactionModel> findAll() {
    return transactionRepository.findAll();
  }

  @Override
  public TransactionModel create(TransactionModel transaction) {
    transaction.setEstado("Pendiente");

    return transactionRepository.save(transaction);
  }

  @Override
  public TransactionModel update(TransactionModel transaction) {
    return transactionRepository.save(transaction);
  }

  @Override
  public void delete(String id) {
    transactionRepository.deleteById(id);
  }

  @Override
  public TransactionModel confirmarTransaccion(String numero) {
    TransactionModel transaction=transactionRepository.findByID(numero);
    if(transaction.getEstado()=="Pendiente"){
      transaction.setEstado("Confirmada");
      realizarPago(transaction);
    }else{
      throw new RuntimeException("Error: transacción ya procesada");
    }

    return transactionRepository.save(transaction);
  }

  @Override
  public TransactionModel findById(String numero) {
    return transactionRepository.findByID(numero);
  }

  private void realizarPago(TransactionModel transaction){
    AccountModel vende=accountRepository.findByDoc(transaction.getVendedor());
    vende.setFondos(vende.getFondos()-transaction.getMonto());

    AccountModel compra=accountRepository.findByDoc(transaction.getComprador());
    compra.setFondos(vende.getFondos()+transaction.getMonto());
  }
}
