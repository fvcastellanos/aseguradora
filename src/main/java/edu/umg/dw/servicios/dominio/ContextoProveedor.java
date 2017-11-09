package edu.umg.dw.servicios.dominio;

import edu.umg.dw.model.Proveedor;

public class ContextoProveedor {

    private String nit;
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
}
