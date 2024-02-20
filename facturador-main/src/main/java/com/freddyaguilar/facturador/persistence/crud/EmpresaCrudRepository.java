package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.EmpresaEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface EmpresaCrudRepository extends CrudRepository<EmpresaEntity, Integer> {
}
