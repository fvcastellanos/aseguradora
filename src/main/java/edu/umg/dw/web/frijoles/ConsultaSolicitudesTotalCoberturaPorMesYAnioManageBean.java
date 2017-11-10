package edu.umg.dw.web.frijoles;

import edu.umg.dw.model.ConsultaCoberturaMesYAnio;
import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class ConsultaSolicitudesTotalCoberturaPorMesYAnioManageBean {

    private static final Logger LOGGER = Logger.getLogger(ConsultaSolicitudesTotalCoberturaPorMesYAnioManageBean.class.getName());

    @EJB
    private ServicioProveedor servicioProveedor;

    private List<ConsultaCoberturaMesYAnio> consultaCoberturaMesYAnios;

    public List<ConsultaCoberturaMesYAnio> getConsultaCoberturaMesYAnios() {
        return consultaCoberturaMesYAnios;
    }

    public String consultar() {
        try {
            this.consultaCoberturaMesYAnios = servicioProveedor.obtenerConsultaTotalCoberturaMesYAnio().getObjeto();
            return "";
        } catch (final Exception exception) {
            LOGGER.log(Level.SEVERE, "No se puede realiza la consulta: ", exception);
        }

        return "";
    }

}
