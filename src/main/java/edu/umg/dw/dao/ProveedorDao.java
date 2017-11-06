package edu.umg.dw.dao;

import edu.umg.dw.model.Proveedor;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProveedorDao {

    List<Proveedor> obtenerProveedores();
}
