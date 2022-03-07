package com.contabancaria.contabancaria.repository;

import com.contabancaria.contabancaria.domain.Checking_Account;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CheckingAccountRepository extends ReactiveSortingRepository<Checking_Account, Long> {

    @Query("Select id from checking_account Where cpf = :cpf")
    Mono<Long> findByCPF(String cpf);

}
