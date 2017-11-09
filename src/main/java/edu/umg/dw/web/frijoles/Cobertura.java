package edu.umg.dw.web.frijoles;

import edu.umg.dw.web.cliente.ClienteServicioProveedores;
import edu.umg.dw.web.cliente.dominio.RespuestaConsultaCobertura;
import org.apache.commons.lang3.time.DateUtils;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class Cobertura {

    private Logger logger = Logger.getLogger(Cobertura.class.getName());

    @Inject
    private ClienteServicioProveedores clienteServicioProveedores;

    @NotNull(message = "El Nit es requerido")
    private String nit;

    @NotNull(message = "No. Poliza es requerido")
    private String noPoliza;

    @NotNull(message = "Fecha de nacimiento es requerida")
    private String fechaNacimiento;

    private String autorizacion;

    private String fechaConsulta;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public void setNoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    //---------------------------------------

    public String verificarCobertura() {
        try {
            Date fecha = DateUtils.parseDate(fechaNacimiento, "dd/MM/yyyy");
            RespuestaConsultaCobertura respuesta = clienteServicioProveedores.consultaCobertura(nit, noPoliza, fecha);

            if ("ERROR".equals(respuesta.getEstado())) {
                autorizacion = respuesta.getMensaje();

                return "";
            }

            fechaConsulta = respuesta.getConsultaCobertura().getFechaConsulta().toString();
            autorizacion = respuesta.getConsultaCobertura().getAutorizacion();

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "No se puede verificar la cobertura: ", ex);
        }

        return "";
    }
}
