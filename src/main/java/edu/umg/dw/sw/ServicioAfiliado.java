package edu.umg.dw.sw;

import edu.umg.dw.model.Poliza;
import edu.umg.dw.servicios.ServicioPoliza;

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
    private ServicioPoliza servicioPoliza;

    @WebMethod
    public List<Poliza> obtenerPolizas() {
        return null;
    }

    @WebMethod
    public Poliza obtenerPoliza(@WebParam int id) {
        return null;
    }

    @WebMethod
    public Poliza crearPoliza(@WebParam Poliza poliza) {
        return null;
    }

    @WebMethod
    public Poliza actualizarPoliza(@WebParam Poliza poliza) {
        return null;
    }
}
