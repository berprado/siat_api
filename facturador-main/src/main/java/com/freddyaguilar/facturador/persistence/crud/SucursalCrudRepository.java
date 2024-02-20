package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.SucursalEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface SucursalCrudRepository extends CrudRepository<SucursalEntity, Integer> {
}
