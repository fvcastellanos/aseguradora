package edu.umg.dw.web.frijoles;

import edu.umg.dw.model.ConsultaCobertura;
import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class ConsultaSolicitudesCoberturaManageBean {

    private static final Logger LOGGER = Logger.getLogger(ConsultaSolicitudesCoberturaManageBean.class.getName());

    @EJB
    private ServicioProveedor servicioProveedor;

    @NotNull(message = "El nit es requerido")
    private String nit;

    private List<ConsultaCobertura> consultaCoberturas;

    public void setNit(final String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public List<ConsultaCobertura> getConsultaCoberturas() {
        return consultaCoberturas;
    }

    public String consultar() {
        try {
            this.consultaCoberturas = servicioProveedor.obtenerConsultasCobertura(nit).getObjeto();
            return "";
        } catch (final Exception exception) {
            LOGGER.log(Level.SEVERE, "No se puede realiza la consulta: ", exception);
        }

        return "";
    }

}
