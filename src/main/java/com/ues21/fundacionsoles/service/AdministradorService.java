package com.ues21.fundacionsoles.service;

import com.ues21.fundacionsoles.model.AdministradorSistema;
import com.ues21.fundacionsoles.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdministradorService implements AdministradorServiceInterface{

    @Autowired
    private AdministradorRepository administradorRepository;
    @Override
    public AdministradorSistema saveAdministrador(AdministradorSistema administradorSistema) {
        return administradorRepository.save(administradorSistema);
    }

    @Override
    public List<AdministradorSistema> fetchAdministradorList() {
        return (List<AdministradorSistema>)administradorRepository.findAll();
    }

    @Override
    public AdministradorSistema fetchAdministradorById(Long idAdministrador) {
        return administradorRepository.findById(idAdministrador).get();
    }


    @Override
    public AdministradorSistema updateAdministrador(AdministradorSistema administradorSistema, Long idAdministrador) {

        AdministradorSistema adminDB = administradorRepository.findById(idAdministrador)
                .get();

        if (Objects.nonNull(administradorSistema.getNombre())
                && !"".equalsIgnoreCase(
                administradorSistema.getNombre())) {
            adminDB.setNombre(
                    administradorSistema.getNombre());
        }

        if (Objects.nonNull(administradorSistema.getApellido())
                && !"".equalsIgnoreCase(
                administradorSistema.getApellido())) {
            adminDB.setApellido(
                    administradorSistema.getApellido());
        }

        return administradorRepository.save(adminDB);

    }

    @Override
    public void deleteAdministradorById(Long idAdministrador) {

        administradorRepository.deleteById(idAdministrador);
    }
}
