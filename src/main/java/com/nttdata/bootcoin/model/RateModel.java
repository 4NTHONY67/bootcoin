package com.nttdata.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rate")
public class RateModel {
  @Id
  private String id;

  private float compra;

  private float venta;

  private String fecha;
}
