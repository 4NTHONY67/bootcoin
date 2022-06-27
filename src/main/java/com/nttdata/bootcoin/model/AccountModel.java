package com.nttdata.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class AccountModel {
  @Id
  private String doc;

  private String tipoDoc;

  private String celular;

  private String correo;

  private float fondos;


}
