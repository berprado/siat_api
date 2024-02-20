package com.freddyaguilar.facturador.application.rest.controller;

import com.freddyaguilar.facturador.domain.service.CufdService;
import com.freddyaguilar.facturador.domain.service.CuisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

/**
 * @author freddyar
 */
@RestController
@RequestMapping("/codigos")
public class CodigosController {

    private final CuisService cuisService;
    private final CufdService cufdService;

    public CodigosController(CuisService cuisService, CufdService cufdService) {
        this.cuisService = cuisService;
        this.cufdService = cufdService;
    }

    @PostMapping("/obtener-cuis/{idPuntoVenta}")
    public ResponseEntity<Object> obtenerCuis(@PathVariable("idPuntoVenta") Integer idPuntoVenta) throws RemoteException {

        this.cuisService.obtenerCuis(idPuntoVenta);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/obtener-cufd/{idPuntoVenta}")
    public ResponseEntity<Object> obtenerCufd(@PathVariable("idPuntoVenta") Integer idPuntoVenta) throws RemoteException {

        this.cufdService.obtenerCufd(idPuntoVenta);
        return ResponseEntity.ok().build();
    }
}
