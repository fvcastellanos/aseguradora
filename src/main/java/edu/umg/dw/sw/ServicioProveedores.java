package edu.umg.dw.sw;

import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.sw.vistas.RespuestaListadoProveedores;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class ServicioProveedores {

    @EJB
    private edu.umg.dw.servicios.ServicioProveedor servicioProveedor;

    public ServicioProveedores() {
    }

    @WebMethod
    public RespuestaListadoProveedores obtenerProveedores() {
        Resultado<String, List<Proveedor>> resultado = servicioProveedor.obtenerProveedores();

        if (resultado.tieneFalla()) {
            return RespuestaListadoProveedores.error(resultado.getError());
        }

        return RespuestaListadoProveedores.exito(resultado.getObjeto());
    }
}
