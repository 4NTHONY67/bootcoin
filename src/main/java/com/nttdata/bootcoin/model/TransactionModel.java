package com.nttdata.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class TransactionModel {
  @Id
  private String id;

  private String comprador;

  private String vendedor;

  private float monto;

  private String modoPago;

  private String estado;

  private String numeroTransaccion;

  private String rate;

  private String fecha;
}
