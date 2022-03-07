package com.contabancaria.contabancaria.domain;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table("CHECKINGACCOUNTS")
@Builder
public class Checking_Account {

    @Id
    private Long id;

    private String name;

    private String cpf;

    private String account_number;

    private String agency;

    private BigDecimal balance;


}
