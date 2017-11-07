package edu.umg.dw.servicios;

import edu.umg.dw.model.Poliza;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioPoliza {
    List<Poliza> obtenerPolizas();
    Poliza obtenerPoliza(int id);
    Poliza crearPoliza(Poliza poliza);
    Poliza actualizarPoliza(Poliza poliza);
}
