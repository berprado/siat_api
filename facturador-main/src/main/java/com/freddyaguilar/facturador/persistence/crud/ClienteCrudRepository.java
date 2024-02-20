package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface ClienteCrudRepository extends CrudRepository<ClienteEntity, Integer> {

}
