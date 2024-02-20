package com.freddyaguilar.facturador.persistence;

import com.freddyaguilar.facturador.domain.repository.IItemRepository;
import com.freddyaguilar.facturador.persistence.crud.ItemCrudRepository;
import com.freddyaguilar.facturador.persistence.entity.ItemEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author freddyar
 */
@Repository
public class ItemRepository implements IItemRepository {

    private final ItemCrudRepository itemCrudRepository;

    public ItemRepository(ItemCrudRepository itemCrudRepository) {
        this.itemCrudRepository = itemCrudRepository;
    }


    @Override
    public Optional<ItemEntity> findById(Integer id) {
        return this.itemCrudRepository.findById(id);
    }
}
