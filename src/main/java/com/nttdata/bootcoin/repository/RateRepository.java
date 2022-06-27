package com.nttdata.bootcoin.repository;

import com.nttdata.bootcoin.model.RateModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RateRepository extends MongoRepository<RateModel, String> {
}
