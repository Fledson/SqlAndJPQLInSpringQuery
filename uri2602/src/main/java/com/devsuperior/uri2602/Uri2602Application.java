package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}


	/** Usando o command line para exibir direto no console*/
	@Override
	public void run(String... args) throws Exception {
		// recebendo a lista gerada pela consulta
		List<CustomerMinProjection> listSQL = repository.searchByStateSQL("rs");
		// convertendo para uma lista de dto
		List<CustomerMinDTO> resultSQL = listSQL.stream().map(entity -> new CustomerMinDTO(entity)).collect(Collectors.toList());
		// exibindo cada nome no console
		System.out.println("CONSULTA COM SQL RAIZ");
		resultSQL.forEach( customer -> System.out.println(customer));

		/**
		 * * * * * * * * * * * * *
		 */
		// recebendo a lista gerada pela consulta
		List<CustomerMinDTO> listJPQL = repository.searchByStateJPQL("rs");
		// exibindo cada nome no console
		System.out.println("CONSULTA COM JPQL");
		listJPQL.forEach( customer -> System.out.println(customer));
	}
}
