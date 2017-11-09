package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.Poliza;

import java.util.List;

public class RespuestaListadoPolizas extends RespuestaBase {

    private List<Poliza> polizas;

    public RespuestaListadoPolizas() {
        super("", "");
    }

    private RespuestaListadoPolizas(String estado, String mensaje, List<Poliza> polizas) {
        super(estado, mensaje);
        this.polizas = polizas;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public static RespuestaListadoPolizas exito(List<Poliza> polizas) {
        return new RespuestaListadoPolizas("OK", null, polizas);
    }

    public static RespuestaListadoPolizas error(String mensaje) {
        return new RespuestaListadoPolizas("ERROR", mensaje, null);
    }

}
