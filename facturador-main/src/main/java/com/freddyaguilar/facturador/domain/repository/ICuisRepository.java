package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.RespuestaCuis;
import com.freddyaguilar.facturador.persistence.entity.CuisEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface ICuisRepository {

    void save(RespuestaCuis respuestaCuis, PuntoVentaEntity puntoVenta);

    Optional<CuisEntity> findActual(PuntoVentaEntity puntoVenta);
}
