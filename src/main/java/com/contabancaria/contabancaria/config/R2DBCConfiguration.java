package com.contabancaria.contabancaria.config;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

public class R2DBCConfiguration {

 //   @Bean
    //   public H2ConnectionFactory connectionFactory() {
    //  return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
    //          .url("mem:contacorrentedb:DB_CLOSE_DELAY=-1;IGNORECASE=TRUE;")
    //          .username("sa")
    //          .build());
    //}
}
