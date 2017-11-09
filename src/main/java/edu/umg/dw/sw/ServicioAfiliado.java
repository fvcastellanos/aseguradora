package edu.umg.dw.sw;

import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;
import edu.umg.dw.servicios.ServicioPoliza;
import edu.umg.dw.sw.vistas.RespuestaBoleta;
import edu.umg.dw.sw.vistas.RespuestaListadoBoletas;
import edu.umg.dw.sw.vistas.RespuestaListadoPolizas;
import edu.umg.dw.sw.vistas.RespuestaPoliza;

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
    public RespuestaListadoPolizas obtenerPolizas() {

        Resultado<String, List<Poliza>> resultado = servicioPoliza.obtenerPolizas();

        if (resultado.tieneFalla()) {
            return RespuestaListadoPolizas.error(resultado.getError());
        }

        return RespuestaListadoPolizas.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaPoliza obtenerPoliza(@WebParam String noPoliza) {

        Resultado<String, Poliza> resultado = servicioPoliza.obtenerPoliza(noPoliza);

        if (resultado.tieneFalla()) {
            return RespuestaPoliza.error(resultado.getError());
        }

        return RespuestaPoliza.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaPoliza crearPoliza(@WebParam Poliza poliza) {

        Resultado<String, Poliza> resultado = servicioPoliza.crearPoliza(poliza);

        if (resultado.tieneFalla()) {
            return RespuestaPoliza.error(resultado.getError());
        }

        return RespuestaPoliza.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaPoliza actualizarPoliza(@WebParam Poliza poliza) {

        Resultado<String, Poliza> resultado = servicioPoliza.actualizarPoliza(poliza);

        if (resultado.tieneFalla()) {
            return RespuestaPoliza.error(resultado.getError());
        }

        return RespuestaPoliza.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaListadoBoletas obtenerBoletasPoliza(@WebParam String noPoliza) {

        Resultado<String, List<Boleta>> resultado = servicioPoliza.obtenerBoletasPoliza(noPoliza);

        if (resultado.tieneFalla()) {
            return RespuestaListadoBoletas.error(resultado.getError());
        }

        return RespuestaListadoBoletas.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaBoleta pagarBoleta(@WebParam String noPoliza, @WebParam int mes, @WebParam int anio) {

        Resultado<String, Boleta> resultado = servicioPoliza.pagarBoleta(noPoliza, mes, anio);

        if (resultado.tieneFalla()) {
            return RespuestaBoleta.error(resultado.getError());
        }

        return RespuestaBoleta.exito(resultado.getObjeto());
    }

}
