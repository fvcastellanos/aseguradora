package edu.umg.dw.servicios;

import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioPoliza {

    Resultado<String, List<Poliza>> obtenerPolizas();
    Resultado<String, Poliza> obtenerPoliza(String noPoliza);

    Resultado<String, Poliza> crearPoliza(Poliza poliza);
    Resultado<String, Poliza> actualizarPoliza(Poliza poliza);

    Resultado<String, List<Boleta>> obtenerBoletasPoliza(String noPoliza);
    Resultado<String, Boleta> pagarBoleta(String noPoliza, int mes, int anio);

}
