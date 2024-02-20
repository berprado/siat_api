package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.ProductoServicioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface ProductoServicioCrudRepository extends CrudRepository<ProductoServicioEntity, Long> {

    Optional<ProductoServicioEntity> findByCodigoProducto(Long codigoProducto);
}
