package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.ParametroEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface ParametroCrudRepository extends CrudRepository<ParametroEntity, Long> {
}
