package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.CoordinadorArea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinadorAreaRepository extends CrudRepository<CoordinadorArea, Long> {
}
