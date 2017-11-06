package edu.umg.dw.sw;

import edu.umg.dw.model.Asegurado;
import edu.umg.dw.servicios.ServicioAsegurado;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class ServicioAfiliado {

    @EJB
    private ServicioAsegurado servicioAsegurado;

    @WebMethod
    public String eco() {
        return "estoy vivo..";
    }

    @WebMethod
    public List<Asegurado> obtenerAsegurados() {
        return servicioAsegurado.obtenerAsegurados();
    }

    @WebMethod
    public Asegurado crearAsegurado(@WebParam Asegurado asegurado) {
        return servicioAsegurado.crearAsegurado(asegurado);
    }

    @WebMethod
    public Asegurado obtenerAsegurado(@WebParam int id) {
        return servicioAsegurado.obtenerAsegurado(id);
    }

    @WebMethod
    public Asegurado actualizarAsegurado(@WebParam Asegurado asegurado) {
        return servicioAsegurado.actualizarAsegurado(asegurado);
    }
}
