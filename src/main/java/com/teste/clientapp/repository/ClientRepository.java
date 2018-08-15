package com.teste.clientapp.repository;

import com.teste.clientapp.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("ClientRepo")
public interface ClientRepository extends CrudRepository<Client, Long> {

}
