package edu.umg.dw.servicios.ejb;


import edu.umg.dw.model.Proveedor;
import edu.umg.dw.servicios.ServicioProveedor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ServicioProveedorDefault implements ServicioProveedor {

    private Logger logger = Logger.getLogger(ServicioProveedorDefault.class.getName());


    @Override
    public List<Proveedor> obtenerProveedores() {

        logger.info("Obteniendo el listado de proveedores");

/*
        Proveedor proveedor = new Proveedor();
        proveedor.setNit("2342423");
        proveedor.setId(123);
        proveedor.setNombre("Cosita...");

        return Lists.newArrayList(proveedor);
*/
        return null;
    }
}
