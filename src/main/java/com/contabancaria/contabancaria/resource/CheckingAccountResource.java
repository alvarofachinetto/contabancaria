package com.contabancaria.contabancaria.resource;

import com.contabancaria.contabancaria.domain.dto.Checking_AccountDTO;
import com.contabancaria.contabancaria.service.CheckingAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/checking_accounts")
@AllArgsConstructor
public class CheckingAccountResource {

    private final CheckingAccountService checkingAccountService;

    @GetMapping
    public Flux<Checking_AccountDTO> listAllAccounts(){
        return checkingAccountService.findAllAccounts();
    }

    @GetMapping("/{id}")
    public Mono<Checking_AccountDTO> listByCustomerAccount(@PathVariable Long id){
        return checkingAccountService.findPerAccount(id);
    }

    @PostMapping
    public Mono<Checking_AccountDTO> listByCustomerAccount(@Valid @RequestBody Mono<Checking_AccountDTO> checking_accountDTO){
        return checkingAccountService.createAccount(checking_accountDTO);
    }

    @DeleteMapping("/{cpf}")
    public Mono<Void> listByCustomerAccount(@PathVariable String cpf){
        return checkingAccountService.deleteAccount(cpf);
    }
}
