package com.freddyaguilar.facturador.domain.service;

import bo.gob.impuestos.siat.RespuestaRecepcion;
import com.freddyaguilar.facturador.application.request.VentaRequest;
import com.freddyaguilar.facturador.application.response.FacturaResponse;
import com.freddyaguilar.facturador.application.rest.exception.ProcessException;
import com.freddyaguilar.facturador.domain.FacturaElectronicaCompraVenta;
import com.freddyaguilar.facturador.domain.repository.ICufdRepository;
import com.freddyaguilar.facturador.domain.repository.IPuntoVentaRepository;
import com.freddyaguilar.facturador.domain.service.emision.EnvioFacturaService;
import com.freddyaguilar.facturador.domain.service.emision.GeneraFacturaService;
import com.freddyaguilar.facturador.persistence.entity.CufdEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author freddyar
 */
@Service
public class FacturacionService {

    private final GeneraFacturaService generaFacturaService;
    private final EnvioFacturaService envioFacturaService;
    private final IPuntoVentaRepository puntoVentaRepository;
    private final ICufdRepository cufdRepository;

    public FacturacionService(
        GeneraFacturaService generaFacturaService,
        EnvioFacturaService envioFacturaService,
        IPuntoVentaRepository puntoVentaRepository,
        ICufdRepository cufdRepository
    ) {
        this.generaFacturaService = generaFacturaService;
        this.envioFacturaService = envioFacturaService;
        this.puntoVentaRepository = puntoVentaRepository;
        this.cufdRepository = cufdRepository;
    }

    public FacturaResponse emitirFactura(VentaRequest ventaRequest) throws Exception {

        Optional<PuntoVentaEntity> puntoVenta = this.puntoVentaRepository.findById(ventaRequest.getIdPuntoVenta());
        if (puntoVenta.isEmpty()) throw new ProcessException("Punto venta no encontrado");

        Optional<CufdEntity> cufd = cufdRepository.findActual(puntoVenta.get());
        if (cufd.isEmpty()) throw new ProcessException("Cufd vigente no encontrado");

        FacturaElectronicaCompraVenta factura = this.generaFacturaService.llenarDatos(ventaRequest, cufd.get());
        byte[] xmlComprimidoZip = this.generaFacturaService.obtenerArchivo(factura);

        RespuestaRecepcion respuestaRecepcion = this.envioFacturaService.enviar(puntoVenta.get(), cufd.get(), xmlComprimidoZip);

        FacturaResponse facturaResponse = new FacturaResponse();
        facturaResponse.setCodigoEstado(respuestaRecepcion.getCodigoEstado());
        facturaResponse.setCuf(factura.getCabecera().getCuf());
        facturaResponse.setNumeroFactura(factura.getCabecera().getNumeroFactura());

        return facturaResponse;
    }
}
