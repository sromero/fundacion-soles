package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.CoordinadorArea;
import com.ues21.fundacionsoles.repository.CoordinadorAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CoordinadorAreaService implements CoordinadorAreaServiceInterface{

    @Autowired
    private CoordinadorAreaRepository coordinadorAreaRepository;
    @Override
    public CoordinadorArea saveCoordinadorA(CoordinadorArea coordinadorArea) {
        return coordinadorAreaRepository.save(coordinadorArea);
    }

    @Override
    public List<CoordinadorArea> fetchCoordinadorAreaList() {
        return (List<CoordinadorArea>)coordinadorAreaRepository.findAll();
    }

    @Override
    public CoordinadorArea fetchCoordinadorAreaById(Long idCoordinador) {
        return coordinadorAreaRepository.findById(idCoordinador).get();
    }

    @Override
    public CoordinadorArea updateCoordinadorArea(CoordinadorArea coordinadorArea, Long idCoordinador) {

        CoordinadorArea coordinadorADB = coordinadorAreaRepository.findById(idCoordinador)
                .get();

        if (Objects.nonNull(coordinadorArea.getNombre())
                && !"".equalsIgnoreCase(
                coordinadorArea.getNombre())) {
            coordinadorADB.setNombre(
                    coordinadorArea.getNombre());
        }

        if (Objects.nonNull(coordinadorArea.getApellido())
                && !"".equalsIgnoreCase(
                coordinadorArea.getApellido())) {
            coordinadorADB.setApellido(
                    coordinadorArea.getApellido());
        }

        if (Objects.nonNull(coordinadorArea.getIdCoordinador())
                && !"".equalsIgnoreCase(
                String.valueOf(coordinadorArea.getIdCoordinador()))) {
            coordinadorADB.setIdCoordinador(
                    coordinadorArea.getIdCoordinador());
        }

        return coordinadorAreaRepository.save(coordinadorADB);
    }

    @Override
    public void deleteCoordinadorAreaById(Long idCoordinador) {

        coordinadorAreaRepository.deleteById(idCoordinador);

    }
}
