package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author freddyar
 */
public interface ItemCrudRepository extends CrudRepository<ItemEntity, Integer> {

}
