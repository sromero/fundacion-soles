package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.Area;
import com.ues21.fundacionsoles.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AreaService implements AreaServiceInterface{

    @Autowired
    private AreaRepository areaRepository;
    @Override
    public Area saveArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public List<Area> fetchAreaList() {
        return (List<Area>)areaRepository.findAll();
    }

    @Override
    public Area fetchAreaById(Long idArea) {
        return areaRepository.findById(idArea).get();
    }

    @Override
    public Area updateArea(Area area, Long idArea) {

        Area areaDB
                = areaRepository.findById(idArea)
                .get();

        if (Objects.nonNull(area.getNombre())
                && !"".equalsIgnoreCase(
                area.getNombre())) {
            areaDB.setNombre(
                    area.getNombre());
        }

        if (Objects.nonNull(
                area.getCantidadTareas())
                && !"".equalsIgnoreCase(
                String.valueOf(area.getCantidadTareas()))) {
            areaDB.setCantidadTareas(
                    area.getCantidadTareas());
        }

        if (Objects.nonNull(
                area.getCantidadVoluntarios())
                && !"".equalsIgnoreCase(
                String.valueOf(area.getCantidadVoluntarios()))) {
            areaDB.setCantidadVoluntarios(
                    area.getCantidadVoluntarios());
        }

        if (Objects.nonNull(area.getVoluntarios())
                && !"".equalsIgnoreCase(
                area.getVoluntarios().toString())) {
            areaDB.setVoluntarios(
                    area.getVoluntarios());
        }

        return areaRepository.save(areaDB);

    }



    @Override
    public void deleteAreaById(Long idArea) {

        areaRepository.deleteById(idArea);

    }
}
