package com.contabancaria.contabancaria.service;

import com.contabancaria.contabancaria.domain.Checking_Account;
import com.contabancaria.contabancaria.domain.converter.CheckingAccountConverter;
import com.contabancaria.contabancaria.domain.dto.Checking_AccountDTO;
import com.contabancaria.contabancaria.repository.CheckingAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Random;

@Service
@AllArgsConstructor
public class CheckingAccountService {

    private final CheckingAccountRepository checkingAccountRepository;

    public Flux<Checking_AccountDTO> findAllAccounts(){
        return checkingAccountRepository.findAll()
                                    .map(CheckingAccountConverter::toReadDTO);
    }

    public Mono<Checking_AccountDTO> findPerAccount(Long id){
        return checkingAccountRepository.findById(id)
                .map(CheckingAccountConverter::toReadDTO);
    }

    public Mono<Checking_AccountDTO> createAccount(Mono<Checking_AccountDTO> checking_accountDTO){


        return checking_accountDTO
                .map(checking_accountNew -> {

                    var newCheckingAccount = CheckingAccountConverter.toEntity(checking_accountNew);
                    newCheckingAccount.setAccount_number(numberAccountGenerator());
                    newCheckingAccount.setAgency("0001");
                    newCheckingAccount.setBalance(new BigDecimal(0));

                    return newCheckingAccount;
                })
                .flatMap(checkingAccountRepository::save)
                .map(CheckingAccountConverter::toDTO)
                .onErrorMap(error ->  new RuntimeException("CPF unaceptable"));
    }

    public Mono<Void> deleteAccount(String cpf){
         Long id = checkingAccountRepository.findByCPF(cpf).block();
         return checkingAccountRepository.deleteById(id);
    }

    private static String numberAccountGenerator(){
        Random random = new Random();
        return String.valueOf(random.nextInt(9999999 - 111111) + 111111);
    }


}
