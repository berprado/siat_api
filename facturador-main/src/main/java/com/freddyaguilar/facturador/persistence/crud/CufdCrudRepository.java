package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.CufdEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface CufdCrudRepository extends CrudRepository<CufdEntity, Integer> {

    Optional<CufdEntity> findByPuntoVentaAndVigente(PuntoVentaEntity puntoVenta, boolean vigente);
}
