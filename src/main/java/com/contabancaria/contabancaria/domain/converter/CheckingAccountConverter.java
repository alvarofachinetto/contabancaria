package com.contabancaria.contabancaria.domain.converter;

import com.contabancaria.contabancaria.domain.Checking_Account;
import com.contabancaria.contabancaria.domain.dto.Checking_AccountDTO;

public class CheckingAccountConverter {

    public static Checking_Account toEntity(final Checking_AccountDTO checking_accountDTO){
        var checkingAccount = new Checking_Account();
        return checkingAccount.builder()
                .name(checking_accountDTO.getName())
                .cpf(checking_accountDTO.getCpf())
                .build();
    }

    public static Checking_AccountDTO toDTO(final Checking_Account checking_account){
        var checkingAccountDTO = new Checking_AccountDTO();
        return checkingAccountDTO.builder()
                .name(checking_account.getName())
                .cpf(checking_account.getCpf())
                .build();

    }

    public static Checking_AccountDTO toReadDTO(final Checking_Account checking_account){
        var checkingAccountDTO = new Checking_AccountDTO();
        return checkingAccountDTO.builder()
                .name(checking_account.getName())
                .cpf(checking_account.getCpf())
                .agency(checking_account.getAgency())
                .account_number(checking_account.getAccount_number())
                .balance(checking_account.getBalance())
                .build();

    }



}
