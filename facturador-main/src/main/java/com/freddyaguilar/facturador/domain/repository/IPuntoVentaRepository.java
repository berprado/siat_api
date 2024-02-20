package com.freddyaguilar.facturador.domain.repository;

import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface IPuntoVentaRepository {

    Optional<PuntoVentaEntity> findById(Integer id);

    Optional<PuntoVentaEntity> findByCodigo(Integer codigo);
}
