package com.nttdata.bootcoin.repository;

import com.nttdata.bootcoin.model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TransactionRepository extends MongoRepository<TransactionModel, String> {

  @Query("{numeroTransaccion: ?0 }")
  public TransactionModel findByID(String numero);
}
