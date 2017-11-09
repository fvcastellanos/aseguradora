package edu.umg.dw.web.cliente;

import edu.umg.dw.web.cliente.dominio.RespuestaConsultaCobertura;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface ClienteServicioProveedores {
    RespuestaConsultaCobertura consultaCobertura(String nit, String noPoliza, Date fechaNacimiento);
}
