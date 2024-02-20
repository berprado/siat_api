package com.freddyaguilar.facturador.persistence.crud;

import com.freddyaguilar.facturador.persistence.entity.LeyendaFacturaEntity;
import com.freddyaguilar.facturador.persistence.view.LeyendaView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface LeyendaFacturaCrudRepository extends CrudRepository<LeyendaFacturaEntity, Long> {

    @Query(
        value = "select" +
                "   RANDOM() as random, l.descripcion_leyenda as leyenda " +
                "from leyenda_factura l " +
                "where l.codigo_actividad = :codigoActividad " +
                "ORDER BY random LIMIT 1",
        nativeQuery = true
    )
    Optional<LeyendaView> obtenerLeyenda(@Param("codigoActividad") String codigoActividad);
}
