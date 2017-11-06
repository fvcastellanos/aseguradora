package edu.umg.dw.sw;

import edu.umg.dw.model.Asegurado;
import edu.umg.dw.servicios.ServicioAsegurado;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@Stateless
@WebService
public class ServicioAfiliado {

    @EJB
    private ServicioAsegurado servicioAsegurado;

    @WebMethod
    public String eco() {
        return "estoy vivo..";
    }

    @WebMethod
    public List<Asegurado> obtenerAsegurados() {
        return servicioAsegurado.obtenerAsegurados();
    }

    @WebMethod
    public Asegurado crearAsegurado(@WebParam String primerNombre,
                                    @WebParam String segundoNombre,
                                    @WebParam String primerApellido,
                                    @WebParam String segundoApellido,
                                    @WebParam String telefono,
                                    @WebParam Date fechaNacimiento) {

        Asegurado asegurado = Asegurado.newBuilder()
                .primerNombre(primerNombre)
                .primerApellido(primerApellido)
                .segundoNombre(segundoNombre)
                .segundoApellido(segundoApellido)
                .telefono(telefono)
                .fechaNacimiento(fechaNacimiento)
                .activo(1)
                .build();

        return servicioAsegurado.crearAsegurado(asegurado);
    }
}
