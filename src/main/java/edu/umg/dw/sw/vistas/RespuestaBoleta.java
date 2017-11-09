package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Boleta;

public class RespuestaBoleta extends RespuestaBase {

    private Boleta boleta;

    public RespuestaBoleta() {
        super("", "");
    }

    private RespuestaBoleta(String estado, String mensaje, Boleta boleta) {
        super(estado, mensaje);
        this.boleta = boleta;
    }

    public static RespuestaBoleta exito(Boleta boleta) {
        return new RespuestaBoleta("OK", "", boleta);
    }

    public static RespuestaBoleta error(String mensaje) {
        return new RespuestaBoleta("ERROR", mensaje, null);
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }
}
