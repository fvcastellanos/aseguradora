package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Poliza;

public class RespuestaPoliza extends RespuestaBase {

    private Poliza poliza;

    public RespuestaPoliza() {
        super("", "");
    }

    private RespuestaPoliza(String estado, String mensaje, Poliza poliza) {
        super(estado, mensaje);
        this.poliza = poliza;
    }

    public static RespuestaPoliza exito(Poliza poliza) {
        return new RespuestaPoliza("OK", null, poliza);
    }

    public static RespuestaPoliza error(String mensaje) {
        return new RespuestaPoliza("ERROR", mensaje, null);
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }


}
