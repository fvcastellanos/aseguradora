package edu.umg.dw.web.frijoles;

import edu.umg.dw.model.ConsultaCoberturaMesYAnio;
import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
public class ConsultaSolicitudesCoberturaPorMesYAnioManageBean {

    private static final Logger LOGGER = Logger.getLogger(ConsultaSolicitudesCoberturaPorMesYAnioManageBean.class.getName());

    @EJB
    private ServicioProveedor servicioProveedor;

    @NotNull(message = "El número de poliza es requerido")
    private String noPoliza;

    private List<ConsultaCoberturaMesYAnio> consultaCoberturaMesYAnios;

    public void setNoPoliza(final String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public List<ConsultaCoberturaMesYAnio> getConsultaCoberturaMesYAnios() {
        return consultaCoberturaMesYAnios;
    }

    public String consultar() {
        try {
            this.consultaCoberturaMesYAnios = servicioProveedor.obtenerConsultaCoberturaMesYAnio(noPoliza).getObjeto();
            return "";
        } catch (final Exception exception) {
            LOGGER.log(Level.SEVERE, "No se puede realiza la consulta: ", exception);
        }

        return "";
    }

}
