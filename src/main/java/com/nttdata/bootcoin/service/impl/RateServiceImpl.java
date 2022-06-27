package com.nttdata.bootcoin.service.impl;

import com.nttdata.bootcoin.model.RateModel;
import com.nttdata.bootcoin.repository.RateRepository;
import com.nttdata.bootcoin.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {
  @Autowired
  RateRepository rateRepository;

  @Override
  public List<RateModel> findAll() {
    return rateRepository.findAll();
  }

  @Override
  public RateModel create(RateModel rate) {
    return rateRepository.save(rate);
  }

  @Override
  public RateModel update(RateModel rate) {
    return rateRepository.save(rate);
  }

  @Override
  public void delete(String id) {
    rateRepository.deleteById(id);
  }
}
