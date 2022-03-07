package com.contabancaria.contabancaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableR2dbcRepositories
public class ContabancariaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContabancariaApplication.class, args);
	}

	@Value("classpath:h2/init.sql")
	private Resource initSQL;

	@Autowired
	private R2dbcEntityTemplate r2dbcEntityTemplate;

	@Override
	public void run(String... args) throws Exception {

		String query = StreamUtils.copyToString(initSQL.getInputStream(), StandardCharsets.UTF_8);
		System.out.println(query);
		r2dbcEntityTemplate.getDatabaseClient().sql(query)
				.then()
				.subscribe();

	}

}
