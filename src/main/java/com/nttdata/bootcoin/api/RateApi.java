package com.nttdata.bootcoin.api;

import com.nttdata.bootcoin.model.RateModel;
import com.nttdata.bootcoin.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "rate")
public class RateApi {

  @Autowired
  private RateService rateService;

  @GetMapping
  public List<RateModel> findAll(){
    return rateService.findAll();
  }

  @PostMapping
  public ResponseEntity<RateModel> create(@RequestBody RateModel rate) {
    RateModel response = rateService.create(rate);
    return new ResponseEntity<RateModel>(response, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<RateModel> update(@RequestBody RateModel rate) {
    RateModel response = rateService.update(rate);
    return  ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    rateService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
