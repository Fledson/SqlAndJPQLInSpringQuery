package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinProjectionDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=============== CONSULTA SQL ===============");
		// Buscando no banco
		List<MovieMinProjection> listSQL =  repository.searchMoviesByGenreSQL("Action");
		// transformando a lista para DTO
		List<MovieMinProjectionDTO> listDtoSQL = listSQL.stream().map(entity -> new MovieMinProjectionDTO(entity)).collect(Collectors.toList());
		// listando retorno
		listDtoSQL.forEach(entity -> System.out.println(entity));

		System.out.println("=============== CONSULTA JPQL ===============");
		// buscando no banco
		List<MovieMinProjectionDTO> listDtoJPQL = repository.searchMoviesByGenreJPQL("Action");
		// apresentando
		listDtoJPQL.forEach(entity -> System.out.println(entity));
	}
}
