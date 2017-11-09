package edu.umg.dw.sw.vistas;

import edu.umg.dw.model.ConsultaCobertura;

public class RespuestaConsultaCobertura extends RespuestaBase {

    private ConsultaCobertura consultaCobertura;

    public RespuestaConsultaCobertura() {
        super("", "");
    }

    private RespuestaConsultaCobertura(final String estado, final String mensaje, final ConsultaCobertura consultaCobertura) {
        super(estado, mensaje);
        this.consultaCobertura = consultaCobertura;
    }

    public static RespuestaConsultaCobertura exito(final ConsultaCobertura consultaCobertura) {
        return new RespuestaConsultaCobertura("OK", null, consultaCobertura);
    }

    public static RespuestaConsultaCobertura error(final String mensaje) {
        return new RespuestaConsultaCobertura("ERROR", mensaje, null);
    }

    public ConsultaCobertura getConsultaCobertura() {
        return consultaCobertura;
    }

    public void setConsultaCobertura(final ConsultaCobertura consultaCobertura) {
        this.consultaCobertura = consultaCobertura;
    }
    
}
