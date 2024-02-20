package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.ProductosDto;
import com.freddyaguilar.facturador.persistence.entity.ProductoServicioEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface IProductoServicioRepository {

    void save(ProductosDto productosDto);

    void deleteAll();

    Optional<ProductoServicioEntity> findByCodigoProducto(Long codigoProducto);
}
