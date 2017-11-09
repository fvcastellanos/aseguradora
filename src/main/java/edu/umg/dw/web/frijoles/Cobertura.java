package edu.umg.dw.web.frijoles;

import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ManagedBean
public class Cobertura {

    @EJB
    private ServicioProveedor servicioProveedor;

    @NotNull(message = "El Nit es requerido")
    private String nit;

    @NotNull(message = "No. Poliza es requerido")
    private String noPoliza;

    @NotNull(message = "Fecha de nacimiento es requerida")
    @Pattern(regexp = "##/##/####", message = "Formato de fecha invalida")
    private String fechaNacimiento;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public void setNoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String verificarCobertura() {

        String k = "";

        return k;
    }
}
