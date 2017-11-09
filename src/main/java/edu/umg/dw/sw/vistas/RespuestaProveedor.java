package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Proveedor;

public class RespuestaProveedor extends RespuestaBase {

    private Proveedor proveedor;

    public RespuestaProveedor() {
        super("", "");
    }

    private RespuestaProveedor(String estado, String mensaje, Proveedor poliza) {
        super(estado, mensaje);
        this.proveedor = poliza;
    }

    public static RespuestaProveedor exito(Proveedor proveedor) {
        return new RespuestaProveedor("OK", null, proveedor);
    }

    public static RespuestaProveedor error(String mensaje) {
        return new RespuestaProveedor("ERROR", mensaje, null);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
