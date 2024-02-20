package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.ActividadEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface ActividadCrudRepository extends CrudRepository<ActividadEntity, Long> {
}
