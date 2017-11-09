package edu.umg.dw.sw;

import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;
import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.ServicioPoliza;
import edu.umg.dw.servicios.ServicioProveedor;
import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.sw.vistas.RespuestaBoleta;
import edu.umg.dw.sw.vistas.RespuestaListadoBoletas;
import edu.umg.dw.sw.vistas.RespuestaListadoPolizas;
import edu.umg.dw.sw.vistas.RespuestaListadoProveedores;
import edu.umg.dw.sw.vistas.RespuestaPoliza;
import edu.umg.dw.sw.vistas.RespuestaProveedor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class ServicioAseguradora {

    @EJB
    private ServicioPoliza servicioPoliza;

    @EJB
    private ServicioProveedor servicioProveedor;

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

    // ---- Proveedores

    @WebMethod
    public RespuestaListadoProveedores obtenerProveedores() {

        Resultado<String, List<Proveedor>> resultado = servicioProveedor.obtenerProveedores();

        if (resultado.tieneFalla()) {
            return RespuestaListadoProveedores.error(resultado.getError());
        }

        return RespuestaListadoProveedores.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaProveedor agregarProveedor(@WebParam Proveedor proveedor) {
        Resultado<String, Proveedor> resultado = servicioProveedor.agregarProveedor(proveedor);

        if (resultado.tieneFalla()) {
            return RespuestaProveedor.error(resultado.getError());
        }

        return RespuestaProveedor.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaProveedor modificarProveedor(@WebParam Proveedor proveedor) {
        Resultado<String, Proveedor> resultado = servicioProveedor.modificarProveedor(proveedor);

        if (resultado.tieneFalla()) {
            return RespuestaProveedor.error(resultado.getError());
        }

        return RespuestaProveedor.exito(resultado.getObjeto());
    }

    @WebMethod
    public RespuestaProveedor obtenerProveedor(@WebParam String nit) {
        Resultado<String, Proveedor> resultado = servicioProveedor.obtenerProveedor(nit);

        if (resultado.tieneFalla()) {
            return RespuestaProveedor.error(resultado.getError());
        }

        return RespuestaProveedor.exito(resultado.getObjeto());
    }

}
