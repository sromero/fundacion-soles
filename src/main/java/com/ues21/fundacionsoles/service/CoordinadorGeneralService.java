package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.CoordinadorGeneral;
import com.ues21.fundacionsoles.repository.CoordinadorGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CoordinadorGeneralService implements CoordinadorGeneralServiceInterface{


    @Autowired
    private CoordinadorGeneralRepository coordinadorGeneralRepository;
    @Override
    public CoordinadorGeneral saveCoordinadorG(CoordinadorGeneral coordinadorGeneral) {
        return coordinadorGeneralRepository.save(coordinadorGeneral);
    }

    @Override
    public List<CoordinadorGeneral> fetchCoordinadorGeneralList() {
        return (List<CoordinadorGeneral>)coordinadorGeneralRepository.findAll();
    }

    @Override
    public CoordinadorGeneral fetchCoordinadorGeneralById(Long idCoordinador) {
        return coordinadorGeneralRepository.findById(idCoordinador).get();
    }

    @Override
    public CoordinadorGeneral updateCoordinadorGeneral(CoordinadorGeneral coordinadorGeneral, Long idCoordinador) {

        CoordinadorGeneral coordinadorGDB = coordinadorGeneralRepository.findById(idCoordinador)
                .get();


        if (Objects.nonNull(coordinadorGeneral.getNombre())
                && !"".equalsIgnoreCase(
                coordinadorGeneral.getNombre())) {
            coordinadorGDB.setNombre(
                    coordinadorGeneral.getNombre());
        }

        if (Objects.nonNull(coordinadorGeneral.getApellido())
                && !"".equalsIgnoreCase(
                coordinadorGeneral.getApellido())) {
            coordinadorGDB.setApellido(
                    coordinadorGeneral.getApellido());
        }

        return coordinadorGeneralRepository.save(coordinadorGDB);
    }

    @Override
    public void deleteCoordinadorGeneralById(Long idCoordinador) {

        coordinadorGeneralRepository.deleteById(idCoordinador);

    }
}
