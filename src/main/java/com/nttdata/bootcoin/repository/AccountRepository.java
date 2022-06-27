package com.nttdata.bootcoin.repository;

import com.nttdata.bootcoin.model.AccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AccountRepository  extends MongoRepository<AccountModel, String> {
  @Query("{doc: ?0 }")
  public AccountModel findByDoc(String doc);
}
