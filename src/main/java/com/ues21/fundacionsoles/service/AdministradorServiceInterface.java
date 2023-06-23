package com.ues21.fundacionsoles.service;


import com.ues21.fundacionsoles.model.AdministradorSistema;

import java.util.List;

public interface AdministradorServiceInterface {

    // Save operation
    AdministradorSistema saveAdministrador(AdministradorSistema administradorSistema);

    // Read operation
    List<AdministradorSistema> fetchAdministradorList();

    AdministradorSistema fetchAdministradorById(Long idAdministrador);

    // Update operation
    AdministradorSistema updateAdministrador(AdministradorSistema administradorSistema,
                    Long idAdministrador);

    // Delete operation
    void deleteAdministradorById(Long idAdministrador);

}
