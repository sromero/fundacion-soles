package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.Voluntario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends CrudRepository<Voluntario, Long> {

}
