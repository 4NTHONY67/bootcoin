package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.model.RateModel;

import java.util.List;

public interface RateService {
  List<RateModel> findAll();
  RateModel create(RateModel rate);
  RateModel update(RateModel rate);
  void delete(String id);
}
