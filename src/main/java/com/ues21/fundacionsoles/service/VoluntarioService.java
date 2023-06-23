package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.Voluntario;
import com.ues21.fundacionsoles.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VoluntarioService implements VoluntarioServiceInterface {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

   /* public Voluntario getVoluntario(Long idVoluntario) {

        var voluntario = voluntarioRepository.findById(idVoluntario);

        if (voluntario.isEmpty()) {
            return Voluntario.builder().build();
        } else {
            return Voluntario.builder()
                    .apellido(voluntario.get().getApellido())
                    .nombre(voluntario.get().getNombre())
                    .area(voluntario.get().getArea())
                    .correo(voluntario.get().getCorreo())
                    .build();
        }

    }
*/
    @Override
    public Voluntario saveVoluntario(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public List<Voluntario> fetchVoluntarioList() {
        return (List<Voluntario>)voluntarioRepository.findAll();
    }

    @Override
    public Voluntario fetchVoluntarioById(Long id) {
        return voluntarioRepository.findById(id).get();
    }

    @Override
    public Voluntario
    updateVoluntario(Voluntario voluntario,
                     Long id)
    {

        Voluntario volDB
                = voluntarioRepository.findById(id)
                .get();

        if (Objects.nonNull(voluntario.getNombre())
                && !"".equalsIgnoreCase(
                voluntario.getNombre())) {
            volDB.setNombre(
                    voluntario.getNombre());
        }

        if (Objects.nonNull(
                voluntario.getApellido())
                && !"".equalsIgnoreCase(
                voluntario.getApellido())) {
            volDB.setApellido(
                    voluntario.getApellido());
        }

        if (Objects.nonNull(voluntario.getCorreo())
                && !"".equalsIgnoreCase(
                voluntario.getCorreo())) {
            volDB.setCorreo(
                    voluntario.getCorreo());
        }

        if (Objects.nonNull(voluntario.getDireccion())
                && !"".equalsIgnoreCase(
                voluntario.getDireccion())) {
            volDB.setDireccion(
                    voluntario.getDireccion());
        }

        if (Objects.nonNull(voluntario.getTelefono())
                && !"".equalsIgnoreCase(
                String.valueOf(voluntario.getTelefono()))) {
            volDB.setTelefono(
                    voluntario.getTelefono());
        }

        if (Objects.nonNull(voluntario.getDisponibilidadHoraria())
                && !"".equalsIgnoreCase(
                voluntario.getDisponibilidadHoraria())) {
            volDB.setDisponibilidadHoraria(
                    voluntario.getDisponibilidadHoraria());
        }

        if (Objects.nonNull(voluntario.getArea())
                && !"".equalsIgnoreCase(
                String.valueOf(voluntario.getArea()))) {
            volDB.setArea(
                    voluntario.getArea());
        }


        return voluntarioRepository.save(volDB);
    }

    @Override
    public void deleteVoluntarioById(Long id) {

        voluntarioRepository.deleteById(id);

    }
}
