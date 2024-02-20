package com.freddyaguilar.facturador.application.rest.controller;

import com.freddyaguilar.facturador.application.request.VentaRequest;
import com.freddyaguilar.facturador.application.response.FacturaResponse;
import com.freddyaguilar.facturador.domain.service.FacturacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author freddyar
 */
@RestController
@RequestMapping("/factura")
public class FacturacionController {

    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @PostMapping("/emitir")
    public ResponseEntity<FacturaResponse> emitirFactura(@Valid @RequestBody VentaRequest ventaRequest) throws Exception {
        FacturaResponse facturaResponse = this.facturacionService.emitirFactura(ventaRequest);
        return new ResponseEntity<>(facturaResponse, HttpStatus.CREATED);
    }
}
