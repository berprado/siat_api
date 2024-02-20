package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.RespuestaCufd;
import com.freddyaguilar.facturador.persistence.entity.CufdEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface ICufdRepository {

    void save(RespuestaCufd respuestaCufd, PuntoVentaEntity puntoVenta);

    Optional<CufdEntity> findActual(PuntoVentaEntity puntoVenta);
}
