package edu.umg.dw.servicios;

import edu.umg.dw.dominio.Resultado;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioPoliza {
    Resultado<String, List<Poliza>> obtenerPolizas();
//    List<Poliza> obtenerPolizas();
    Poliza obtenerPoliza(int id);
    Poliza crearPoliza(Poliza poliza);
    Poliza actualizarPoliza(Poliza poliza);
    List<Boleta> obtenerBoletasPoliza(int polizaId);
}
