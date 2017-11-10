package edu.umg.dw.servicios;

import edu.umg.dw.model.ConsultaCobertura;
import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.dominio.Resultado;
import edu.umg.dw.sw.vistas.PeticionConsultaPaciente;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
@Remote
public interface ServicioProveedor {

    Resultado<String, List<Proveedor>> obtenerProveedores();
    Resultado<String, Proveedor> obtenerProveedor(String nit);

    Resultado<String, Proveedor> agregarProveedor(Proveedor proveedor);
    Resultado<String, Proveedor> modificarProveedor(Proveedor proveedor);

    Resultado<String, ConsultaCobertura> obtenerConsultaCobertura(PeticionConsultaPaciente peticionConsultaPaciente);
    Resultado<String, List<ConsultaCobertura>> obtenerConsultasCobertura(String nitProveedor);

}
