package edu.umg.dw.web.frijoles;

import edu.umg.dw.model.ConsultaCoberturaNoPago;
import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class ConsultaSolicitudesCoberturaNoPagoManageBean {

    private static final Logger LOGGER = Logger.getLogger(ConsultaSolicitudesCoberturaNoPagoManageBean.class.getName());

    @EJB
    private ServicioProveedor servicioProveedor;

    private List<ConsultaCoberturaNoPago> consultaCoberturaNoPagos;

    public List<ConsultaCoberturaNoPago> getConsultaCoberturaNoPagos() {
        return consultaCoberturaNoPagos;
    }

    public String consultar() {
        try {
            this.consultaCoberturaNoPagos = servicioProveedor.obtenerConsultasCoberturaNoPago().getObjeto();
            return "";
        } catch (final Exception exception) {
            LOGGER.log(Level.SEVERE, "No se puede realiza la consulta: ", exception);
        }

        return "";
    }

}
