package edu.umg.dw.servicios.dominio;

import edu.umg.dw.model.Poliza;
import edu.umg.dw.model.Proveedor;

import java.util.Date;

public class ContextoProveedor {

    private String nit;
    private Poliza poliza;
    private String noPoliza;
    private String autorizacion;
    private Date fechaNacimiento;
    private Proveedor proveedor;

    public ContextoProveedor(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public void setNoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }
}
