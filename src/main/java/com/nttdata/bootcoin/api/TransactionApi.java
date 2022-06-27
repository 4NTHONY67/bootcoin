package com.nttdata.bootcoin.api;

import com.nttdata.bootcoin.model.TransactionModel;
import com.nttdata.bootcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "transaction")
public class TransactionApi {
  @Autowired
  private TransactionService transactionService;

  @GetMapping
  public List<TransactionModel> findAll() {
    return transactionService.findAll();
  }

  @PostMapping
  public ResponseEntity<TransactionModel> create(@RequestBody TransactionModel transaction) {
    TransactionModel response = transactionService.create(transaction);
    return new ResponseEntity<TransactionModel>(response, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<TransactionModel> update(@RequestBody TransactionModel transaction) {
    TransactionModel response = transactionService.update(transaction);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    transactionService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/confirm/{numero}")
  public ResponseEntity<TransactionModel> confirmarTransaccion(@PathVariable("numero") String numero) {
    TransactionModel response = transactionService.confirmarTransaccion(numero);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{numero}")
  public ResponseEntity<TransactionModel> findById(@PathVariable("numero") String numero) {
    TransactionModel response = transactionService.findById(numero);
    return new ResponseEntity<TransactionModel>(response, HttpStatus.FOUND);
  }
}
