package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.FacturaDetalleEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface FacturaDetalleCrudRepository extends CrudRepository<FacturaDetalleEntity, Long> {
}
