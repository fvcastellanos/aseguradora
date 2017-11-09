package edu.umg.dw.web.cliente;

import edu.umg.dw.web.cliente.dominio.ObjectFactory;
import edu.umg.dw.web.cliente.dominio.PeticionConsultaPaciente;
import edu.umg.dw.web.cliente.dominio.RespuestaConsultaCobertura;
import edu.umg.dw.web.cliente.dominio.ServicioProveedores;
import edu.umg.dw.web.cliente.dominio.ServicioProveedoresService;

import javax.ejb.Singleton;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class ClienteServicioProveedoresDefault implements ClienteServicioProveedores {

    private Logger logger = Logger.getLogger(ClienteServicioProveedoresDefault.class.getName());

    private ServicioProveedoresService servicioProveedoresService;
    private ServicioProveedores servicioProveedores;

    public ClienteServicioProveedoresDefault() {
        servicioProveedoresService = new ServicioProveedoresService();
        servicioProveedores = servicioProveedoresService.getServicioProveedoresPort();
    }

    @Override
    public RespuestaConsultaCobertura consultaCobertura(String nit, String noPoliza, Date fechaNacimiento) {
        try {
            PeticionConsultaPaciente peticionConsultaPaciente = construirPeticionConsultaPaciente(nit, noPoliza, fechaNacimiento);
            return servicioProveedores.consultarCoberturaPaciente(peticionConsultaPaciente);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al consultar la cobertura: ", ex);
            return construirRespuestaError("No se pudo realizar la consulta");
        }
    }

    private PeticionConsultaPaciente construirPeticionConsultaPaciente(String nit, String noPoliza, Date fechaNacimiento) throws DatatypeConfigurationException {
        ObjectFactory objectFactory = new ObjectFactory();
        PeticionConsultaPaciente consultaPaciente = objectFactory.createPeticionConsultaPaciente();

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fechaNacimiento);
        XMLGregorianCalendar gregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

        consultaPaciente.setNitProveedor(nit);
        consultaPaciente.setNoPoliza(noPoliza);
        consultaPaciente.setFechaNacimientoPaciente(gregorianCalendar);

        return consultaPaciente;
    }

    private RespuestaConsultaCobertura construirRespuestaError(String mensaje) {
        RespuestaConsultaCobertura respuesta = new RespuestaConsultaCobertura();

        respuesta.setEstado("ERROR");
        respuesta.setMensaje(mensaje);

        return respuesta;
    }
}
