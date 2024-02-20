package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.CuisEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface CuisCrudRepository extends CrudRepository<CuisEntity, Integer> {

    Optional<CuisEntity> findByPuntoVentaAndVigente(PuntoVentaEntity puntoVenta, boolean vigente);
}
