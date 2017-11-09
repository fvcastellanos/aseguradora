package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Proveedor;

import java.util.List;

public class RespuestaListadoProveedores extends RespuestaBase {

    private List<Proveedor> proveedores;

    public RespuestaListadoProveedores() {
        super("", "");
    }

    private RespuestaListadoProveedores(String estado, String mensaje, List<Proveedor> proveedores) {
        super(estado, mensaje);
        this.proveedores = proveedores;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public static RespuestaListadoProveedores exito(List<Proveedor> polizas) {
        return new RespuestaListadoProveedores("OK", null, polizas);
    }

    public static RespuestaListadoProveedores error(String mensaje) {
        return new RespuestaListadoProveedores("ERROR", mensaje, null);
    }

}
