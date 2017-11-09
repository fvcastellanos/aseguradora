package edu.umg.dw.servicios;

import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.dominio.Resultado;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServicioProveedor {

    Resultado<String, List<Proveedor>> obtenerProveedores();
    Resultado<String, Proveedor> obtenerProveedor(String nit);

    Resultado<String, Proveedor> agregarProveedor(Proveedor proveedor);
    Resultado<String, Proveedor> modificarProveedor(Proveedor proveedor);


}
