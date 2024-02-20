package com.freddyaguilar.facturador.persistence;

import com.freddyaguilar.facturador.domain.repository.IFacturaRepository;
import com.freddyaguilar.facturador.persistence.crud.FacturaCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author freddyar
 */
@Repository
public class FacturaRepository implements IFacturaRepository {

    private final FacturaCrudRepository facturaCrudRepository;

    public FacturaRepository(FacturaCrudRepository facturaCrudRepository) {
        this.facturaCrudRepository = facturaCrudRepository;
    }

    @Override
    public Long obtenerNumeroFactura() {
        long cantidad = this.facturaCrudRepository.count();
        return cantidad == 0 ? 1 : cantidad + 1;
    }
}
