package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /** Consulta em sql - nativa */
    @Query(nativeQuery = true, value = " SELECT name FROM customers WHERE UPPER(state) = UPPER(:stateArgs) ")
    List<CustomerMinProjection> searchByStateSQL(String stateArgs);

    /** Consulta em jpql - o nome da tabela tem que ser igual ao da classe desejada
     *  e o campo recebe um new + nome do pacote (classe.campo) para o caso de listar apenas um campo especifico
     *  se fosse a classe toda só o apelido da classe já resolvia
     */
    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) " +
                                        "FROM Customer obj " +
                                        "WHERE UPPER(obj.state) = UPPER(:stateArgs) ")
    List<CustomerMinDTO> searchByStateJPQL(String stateArgs);

}
