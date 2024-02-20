package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface PuntoVentaCrudRepository extends CrudRepository<PuntoVentaEntity, Integer> {

    Optional<PuntoVentaEntity> findByCodigo(Integer codigo);
}
