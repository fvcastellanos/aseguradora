package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Boleta;

import java.util.List;

public class RespuestaListadoBoletas extends RespuestaBase {

    private List<Boleta> boletas;

    public RespuestaListadoBoletas() {
        super("", "");
    }

    private RespuestaListadoBoletas(String estado, String mensaje, List<Boleta> boletas) {
        super(estado, mensaje);
        this.boletas = boletas;
    }

    public static RespuestaListadoBoletas exito(List<Boleta> boletas) {
        return new RespuestaListadoBoletas("OK", "", boletas);
    }

    public static RespuestaListadoBoletas error(String mensaje) {
        return new RespuestaListadoBoletas("ERROR", mensaje, null);
    }

    public List<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<Boleta> boletas) {
        this.boletas = boletas;
    }
}
