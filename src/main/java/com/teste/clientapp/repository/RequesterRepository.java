package com.teste.clientapp.repository;

import com.teste.clientapp.model.Requester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository("RequesterRepo")
public interface RequesterRepository extends CrudRepository<Requester, Long> {

}
