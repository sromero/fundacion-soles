package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.CoordinadorGeneral;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinadorGeneralRepository extends CrudRepository<CoordinadorGeneral, Long> {
}
