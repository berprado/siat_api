package com.freddyaguilar.facturador.persistence;

import bo.gob.impuestos.siat.RespuestaCufd;
import com.freddyaguilar.facturador.domain.repository.ICufdRepository;
import com.freddyaguilar.facturador.persistence.crud.CufdCrudRepository;
import com.freddyaguilar.facturador.persistence.entity.CufdEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import com.freddyaguilar.facturador.persistence.mapper.CufdMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author freddyar
 */
@Repository
public class CufdRepository implements ICufdRepository {

    private final CufdMapper cufdMapper;
    private final CufdCrudRepository cufdCrudRepository;

    public CufdRepository(CufdMapper cufdMapper, CufdCrudRepository cufdCrudRepository) {
        this.cufdMapper = cufdMapper;
        this.cufdCrudRepository = cufdCrudRepository;
    }

    @Override
    public void save(RespuestaCufd respuestaCufd, PuntoVentaEntity puntoVenta) {

        CufdEntity cufd = this.cufdMapper.toCufdEntity(respuestaCufd);
        cufd.setFechaInicio(LocalDateTime.now());
        cufd.setVigente(true);
        cufd.setPuntoVenta(puntoVenta);

        this.cufdCrudRepository.save(cufd);
    }

    @Override
    public Optional<CufdEntity> findActual(PuntoVentaEntity puntoVenta) {
        return this.cufdCrudRepository.findByPuntoVentaAndVigente(puntoVenta, true);
    }
}
