package edu.umg.dw.sw;

import edu.umg.dw.model.Boleta;
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
        return servicioPoliza.obtenerPolizas();
    }

    @WebMethod
    public Poliza obtenerPoliza(@WebParam int id) {
        try {
            return servicioPoliza.obtenerPoliza(id);
        } catch (Exception ex) {

        }

        return null;

    }

    @WebMethod
    public Poliza crearPoliza(@WebParam Poliza poliza) {
        return servicioPoliza.crearPoliza(poliza);
    }

    @WebMethod
    public Poliza actualizarPoliza(@WebParam Poliza poliza) {
        return servicioPoliza.actualizarPoliza(poliza);
    }

    public List<Boleta> obtenerBoletasPoliza(@WebParam int polizaId) {
        return servicioPoliza.obtenerBoletasPoliza(polizaId);
    }
}
