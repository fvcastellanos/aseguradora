package edu.umg.dw.servicios;

import edu.umg.dw.model.Proveedor;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioProveedor {
    List<Proveedor> obtenerProveedores();
}
