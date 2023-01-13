package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<EmpregadoDeptProjection> listSQL = repository.searchEmployeeWhoDoNotWorkingOnAnyProjectSQLOpc1();
		List<EmpregadoDeptDTO> listDtoSQL = listSQL.stream().map( emp -> new EmpregadoDeptDTO(emp) ).collect(Collectors.toList());
		System.out.println("*** SQL RAIZ ***");
		listDtoSQL.forEach( empDto -> System.out.println(empDto));

		System.out.println("\n outra \n");

		List<EmpregadoDeptProjection> listSQL2 = repository.searchEmployeeWhoDoNotWorkingOnAnyProjectSQLOpc2();
		List<EmpregadoDeptDTO> listDtoSQL2 = listSQL.stream().map( emp -> new EmpregadoDeptDTO(emp) ).collect(Collectors.toList());
		System.out.println("*** SQL RAIZ 2 ***");
		listDtoSQL.forEach( empDto -> System.out.println(empDto));

		System.out.println("\n outra \n");


		List<EmpregadoDeptDTO> listDtoJPQL = repository.searchEmployeeWhoDoNotWorkingOnAnyProjectJPSQLOpc1();
		System.out.println("*** JPQL ***");
		listDtoJPQL.forEach( empDto -> System.out.println(empDto));


	}
}
