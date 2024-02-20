package com.freddyaguilar.facturador.persistence;

import bo.gob.impuestos.siat.RespuestaCuis;
import com.freddyaguilar.facturador.domain.repository.ICuisRepository;
import com.freddyaguilar.facturador.persistence.crud.CuisCrudRepository;
import com.freddyaguilar.facturador.persistence.entity.CuisEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import com.freddyaguilar.facturador.persistence.mapper.CuisMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author freddyar
 */
@Repository
public class CuisRepository implements ICuisRepository {

    private final CuisMapper cuisMapper;
    private final CuisCrudRepository cuisCrudRepository;

    public CuisRepository(CuisMapper cuisMapper, CuisCrudRepository cuisCrudRepository) {
        this.cuisMapper = cuisMapper;
        this.cuisCrudRepository = cuisCrudRepository;
    }

    @Override
    public void save(RespuestaCuis respuestaCuis, PuntoVentaEntity puntoVenta) {
        CuisEntity cuis = this.cuisMapper.toCuisEntity(respuestaCuis);
        cuis.setFechaSolicitada(LocalDateTime.now());
        cuis.setVigente(true);
        cuis.setPuntoVenta(puntoVenta);

        this.cuisCrudRepository.save(cuis);
    }

    @Override
    public Optional<CuisEntity> findActual(PuntoVentaEntity puntoVenta) {
        return this.cuisCrudRepository.findByPuntoVentaAndVigente(puntoVenta, true);
    }
}
