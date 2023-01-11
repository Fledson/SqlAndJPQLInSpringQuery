package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** SQL RAIZ ***");
		List<CategorySumProjection> listSql = repository.findCategorySumByAmountProductsSQL();
		List<CategorySumDTO> listDtoSql = listSql.stream().map(categorySumProjection -> new CategorySumDTO(categorySumProjection)).collect(Collectors.toList());
		listDtoSql.forEach(category -> System.out.println(category));

		System.out.println("*** SQL RAIZ ***");
		List<CategorySumDTO> listJpql = repository.findCategorySumByAmountProductsJPQL();
		listJpql.forEach(category -> System.out.println(category));
	}
}
