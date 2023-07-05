package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.Area;
import com.ues21.fundacionsoles.model.Estado;
import com.ues21.fundacionsoles.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class EstadoService implements EstadoServiceInterface{

    @Autowired
    private EstadoRepository estadoRepository;
    @Override
    public Estado saveEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public List<Estado> fetchEstadoList() {
        return (List<Estado>)estadoRepository.findAll();
    }

    @Override
    public Estado fetchEstadoById(Long idEstado) {
        return estadoRepository.findById(idEstado).get();
    }

    @Override
    public Estado updateEstado(Estado estado, Long idEstado) {

        Estado estadoDB
                = estadoRepository.findById(idEstado)
                .get();

        if (Objects.nonNull(estado.getDescripcion())
                && !"".equalsIgnoreCase(
                estado.getDescripcion())) {
            estadoDB.setDescripcion(
                    estado.getDescripcion());
        }

        if (Objects.nonNull(estado.getTareas())
                && !"".equalsIgnoreCase(
                String.valueOf(estado.getTareas()))) {
            estadoDB.setTareas(
                    estado.getTareas());
        }
        return estadoRepository.save(estadoDB);
    }

    @Override
    public void deleteAEstadoById(Long idEstado) {

        estadoRepository.deleteById(idEstado);

    }
}
