package edu.umg.dw.sw;

import edu.umg.dw.servicios.ServicioProveedor;
import edu.umg.dw.model.Proveedor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class ServicioAseguradora {

    @EJB
    private ServicioProveedor servicioProveedor;

    public ServicioAseguradora() {
    }

    @WebMethod
    public String holaMundo() {
        return "Hola Mundo";
    }

    @WebMethod
    public List<Proveedor> obtenerProveedores() {
        return servicioProveedor.obtenerProveedores();
    }
}
