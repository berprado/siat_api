package com.freddyaguilar.facturador.domain.repository;

import com.freddyaguilar.facturador.persistence.entity.ItemEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface IItemRepository {

    Optional<ItemEntity> findById(Integer id);
}
