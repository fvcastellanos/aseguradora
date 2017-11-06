package edu.umg.dw.servicios;

import edu.umg.dw.model.Asegurado;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioAsegurado {
    List<Asegurado> obtenerAsegurados();
    Asegurado obtenerAsegurado(int id);
    Asegurado crearAsegurado(Asegurado asegurado);
    Asegurado actualizarAsegurado(Asegurado asegurado);
}
