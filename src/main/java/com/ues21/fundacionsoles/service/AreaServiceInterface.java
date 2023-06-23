package com.ues21.fundacionsoles.service;


import com.ues21.fundacionsoles.model.Area;

import java.util.List;

public interface AreaServiceInterface {

    // Save operation
    Area saveArea(Area area);

    // Read operation
    List<Area> fetchAreaList();

    Area fetchAreaById(Long idArea);

    // Update operation
    Area updateArea(Area area,
                                Long idArea);

    // Delete operation
    void deleteAreaById(Long idArea);
}
