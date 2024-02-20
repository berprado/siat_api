package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.ParametricaLeyendasDto;
import com.freddyaguilar.facturador.persistence.view.LeyendaView;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface ILeyendaRepository {

    void save(ParametricaLeyendasDto parametricaLeyendasDto);
    void deleteAll();
    Optional<LeyendaView> obtenerLeyenda(String codigoActividad);
}
