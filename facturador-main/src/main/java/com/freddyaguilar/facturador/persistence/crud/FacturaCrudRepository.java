package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.FacturaEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface FacturaCrudRepository extends CrudRepository<FacturaEntity, Long> {
}
