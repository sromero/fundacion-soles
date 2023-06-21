package com.ues21.fundacionsoles.repository;

import com.ues21.fundacionsoles.model.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long> {
}
