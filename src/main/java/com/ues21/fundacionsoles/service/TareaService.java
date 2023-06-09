package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.exception.BaseException;
import com.ues21.fundacionsoles.model.Tarea;
import com.ues21.fundacionsoles.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TareaService implements TareaServiceInterface{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea saveTarea(Tarea tarea) {
        try {
            return tareaRepository.save(tarea);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new BaseException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar la tarea");
        }
    }

    @Override
    public List<Tarea> fetchTareaList() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    @Override
    public List<Tarea> fetchTareaList(Long userId) {
        return (List<Tarea>) tareaRepository.findAll();
    }

    public List<Tarea> fetchTareaListByVoluntario(Long userId) {
        return tareaRepository.findAllByVoluntarioId(userId);
    }

    @Override
    public Tarea fetchTareaById(Long idTarea) {
        return tareaRepository.findById(idTarea).get();
    }

    @Override
    public Tarea updateTarea(Tarea tarea, Long idTarea) {

        Tarea tareaDB
                = tareaRepository.findById(idTarea)
                .get();

        if (Objects.nonNull(tarea.getDescripcion())
                && !"".equalsIgnoreCase(
                tarea.getDescripcion())) {
            tareaDB.setDescripcion(
                    tarea.getDescripcion());
        }

        if (Objects.nonNull(tarea.getFechaFinalizacion())
                && !"".equalsIgnoreCase(
                String.valueOf(tarea.getFechaFinalizacion()))) {
            tareaDB.setFechaFinalizacion(
                    tarea.getFechaFinalizacion());
        }

        if (Objects.nonNull(tarea.getArea())
                && !"".equalsIgnoreCase(
                String.valueOf(tarea.getArea()))) {
            tareaDB.setArea(
                    tarea.getArea());
        }

        return tareaRepository.save(tareaDB);
    }

    @Override
    public void deleteTareaById(Long idTarea) {

        tareaRepository.deleteById(idTarea);
    }
}
