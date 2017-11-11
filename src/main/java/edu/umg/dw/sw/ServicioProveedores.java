package edu.umg.dw.sw;

import edu.umg.dw.model.ConsultaCobertura;
import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.ServicioProveedor;
import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.sw.vistas.PeticionConsultaPaciente;
import edu.umg.dw.sw.vistas.RespuestaConsultaCobertura;
import edu.umg.dw.sw.vistas.RespuestaListadoProveedores;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.logging.Logger;

import static edu.umg.dw.sw.vistas.RespuestaConsultaCobertura.error;
import static edu.umg.dw.sw.vistas.RespuestaConsultaCobertura.exito;

@Stateless
@WebService
public class ServicioProveedores {

    private Logger logger = Logger.getLogger(ServicioProveedores.class.getName());

    @EJB
    private ServicioProveedor servicioProveedor;

    public ServicioProveedores() {
    }

    @WebMethod
    public RespuestaListadoProveedores obtenerProveedores() {

        logger.info("Obteniendo listado de proveedores");
        Resultado<String, List<Proveedor>> resultado = servicioProveedor.obtenerProveedores();

        if (resultado.tieneFalla()) {
            logger.info("no se pudo obtener el listado de proveedores");
            return RespuestaListadoProveedores.error(resultado.getError());
        }

        logger.info("listado de proveedores exitoso");
        return RespuestaListadoProveedores.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaConsultaCobertura consultarCoberturaPaciente(@WebParam(name = "peticionConsultaPaciente") final PeticionConsultaPaciente peticionConsultaPaciente) {
        final Resultado<String, ConsultaCobertura> resultadoConsultaCobertura = servicioProveedor.obtenerConsultaCobertura(peticionConsultaPaciente);

        if (resultadoConsultaCobertura.tieneFalla()) {
            return error(resultadoConsultaCobertura.getError());
        }

        return exito(resultadoConsultaCobertura.getObjeto());
    }

}
