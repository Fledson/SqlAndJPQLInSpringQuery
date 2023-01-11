package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinProjectionDto;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/** SQL */
		System.out.println(" *********** SQL RAIZ *********** ");
		List<ProductMinProjection> listSql = repository.searchNameProductByAmouthAndProvidersSQL(10, 20, "P");
		List<ProductMinProjectionDto> lisqSqlDto = listSql.stream().map(result -> new ProductMinProjectionDto(result)).collect(Collectors.toList());
		lisqSqlDto.forEach(product -> System.out.println(product));

		/** JPQL */
		System.out.println(" *********** JPQL *********** ");
		List<ProductMinProjectionDto> list = repository.searchNameProductByAmouthAndProvidersJPQL(10, 20, "P");
		list.forEach(product -> System.out.println(product));
	}
}
