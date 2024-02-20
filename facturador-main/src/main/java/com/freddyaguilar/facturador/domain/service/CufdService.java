package com.freddyaguilar.facturador.domain.service;

import bo.gob.impuestos.siat.MensajeServicio;
import bo.gob.impuestos.siat.RespuestaCufd;
import bo.gob.impuestos.siat.ServicioFacturacionCodigos;
import bo.gob.impuestos.siat.SolicitudCufd;
import com.freddyaguilar.facturador.application.rest.exception.ProcessException;
import com.freddyaguilar.facturador.config.AppConfig;
import com.freddyaguilar.facturador.domain.repository.ICufdRepository;
import com.freddyaguilar.facturador.domain.repository.ICuisRepository;
import com.freddyaguilar.facturador.domain.repository.IPuntoVentaRepository;
import com.freddyaguilar.facturador.persistence.entity.CuisEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Optional;

/**
 * @author freddyar
 */
@Service
public class CufdService {

    private final AppConfig appConfig;

    private final ServicioFacturacionCodigos servicioFacturacionCodigos;

    private final IPuntoVentaRepository puntoVentaRepository;
    private final ICuisRepository cuisRepository;
    private final ICufdRepository cufdRepository;

    public CufdService(
        AppConfig appConfig,
        ServicioFacturacionCodigos servicioFacturacionCodigos,
        IPuntoVentaRepository puntoVentaRepository,
        ICuisRepository cuisRepository,
        ICufdRepository cufdRepository
    ) {
        this.appConfig = appConfig;
        this.servicioFacturacionCodigos = servicioFacturacionCodigos;
        this.puntoVentaRepository = puntoVentaRepository;
        this.cuisRepository = cuisRepository;
        this.cufdRepository = cufdRepository;
    }

    public void obtenerCufd(Integer idPuntoVenta) throws RemoteException {

        Optional<PuntoVentaEntity> puntoVenta = this.puntoVentaRepository.findById(idPuntoVenta);
        if (puntoVenta.isEmpty()) throw new ProcessException("Punto venta no encontrado");

        Optional<CuisEntity> cuis = this.cuisRepository.findActual(puntoVenta.get());
        if (cuis.isEmpty()) throw new ProcessException("CUIS vigente no encontrado");

        SolicitudCufd solicitudCufd = new SolicitudCufd();
        solicitudCufd.setCodigoAmbiente(this.appConfig.getCodigoAmbiente());
        solicitudCufd.setCodigoModalidad(this.appConfig.getCodigoModalidad());
        solicitudCufd.setCodigoSistema(this.appConfig.getCodigoSistema());
        solicitudCufd.setNit(puntoVenta.get().getSucursal().getEmpresa().getNit());
        solicitudCufd.setCodigoSucursal(puntoVenta.get().getSucursal().getCodigo());
        solicitudCufd.setCodigoPuntoVenta(puntoVenta.get().getCodigo());
        solicitudCufd.setCuis(cuis.get().getCodigo());

        RespuestaCufd respuestaCufd = this.servicioFacturacionCodigos.cufd(solicitudCufd);

        if(!respuestaCufd.getTransaccion() && respuestaCufd.getMensajesList() != null) {
            String mensajes = "";
            for (MensajeServicio mensajeServicio : respuestaCufd.getMensajesList()) {
                mensajes += mensajeServicio.getDescripcion() + ". ";
            }
            throw new ProcessException(mensajes);
        }

        this.cufdRepository.save(respuestaCufd, puntoVenta.get());
    }
}
