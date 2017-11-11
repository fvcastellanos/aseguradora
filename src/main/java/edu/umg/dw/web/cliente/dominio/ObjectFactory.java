
package edu.umg.dw.web.cliente.dominio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.umg.dw.web.cliente.dominio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerProveedoresResponse_QNAME = new QName("http://sw.dw.umg.edu/", "obtenerProveedoresResponse");
    private final static QName _ConsultarCoberturaPacienteResponse_QNAME = new QName("http://sw.dw.umg.edu/", "consultarCoberturaPacienteResponse");
    private final static QName _PeticionConsultaPaciente_QNAME = new QName("http://sw.dw.umg.edu/", "PeticionConsultaPaciente");
    private final static QName _ConsultarCoberturaPaciente_QNAME = new QName("http://sw.dw.umg.edu/", "consultarCoberturaPaciente");
    private final static QName _ObtenerProveedores_QNAME = new QName("http://sw.dw.umg.edu/", "obtenerProveedores");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.umg.dw.web.cliente.dominio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PeticionConsultaPaciente }
     * 
     */
    public PeticionConsultaPaciente createPeticionConsultaPaciente() {
        return new PeticionConsultaPaciente();
    }

    /**
     * Create an instance of {@link ConsultarCoberturaPacienteResponse }
     * 
     */
    public ConsultarCoberturaPacienteResponse createConsultarCoberturaPacienteResponse() {
        return new ConsultarCoberturaPacienteResponse();
    }

    /**
     * Create an instance of {@link ConsultarCoberturaPaciente }
     * 
     */
    public ConsultarCoberturaPaciente createConsultarCoberturaPaciente() {
        return new ConsultarCoberturaPaciente();
    }

    /**
     * Create an instance of {@link ObtenerProveedores }
     * 
     */
    public ObtenerProveedores createObtenerProveedores() {
        return new ObtenerProveedores();
    }

    /**
     * Create an instance of {@link ObtenerProveedoresResponse }
     * 
     */
    public ObtenerProveedoresResponse createObtenerProveedoresResponse() {
        return new ObtenerProveedoresResponse();
    }

    /**
     * Create an instance of {@link RespuestaConsultaCobertura }
     * 
     */
    public RespuestaConsultaCobertura createRespuestaConsultaCobertura() {
        return new RespuestaConsultaCobertura();
    }

    /**
     * Create an instance of {@link ConsultaCobertura }
     * 
     */
    public ConsultaCobertura createConsultaCobertura() {
        return new ConsultaCobertura();
    }

    /**
     * Create an instance of {@link RespuestaListadoProveedores }
     * 
     */
    public RespuestaListadoProveedores createRespuestaListadoProveedores() {
        return new RespuestaListadoProveedores();
    }

    /**
     * Create an instance of {@link Proveedor }
     * 
     */
    public Proveedor createProveedor() {
        return new Proveedor();
    }

    /**
     * Create an instance of {@link Poliza }
     * 
     */
    public Poliza createPoliza() {
        return new Poliza();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProveedoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sw.dw.umg.edu/", name = "obtenerProveedoresResponse")
    public JAXBElement<ObtenerProveedoresResponse> createObtenerProveedoresResponse(ObtenerProveedoresResponse value) {
        return new JAXBElement<ObtenerProveedoresResponse>(_ObtenerProveedoresResponse_QNAME, ObtenerProveedoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCoberturaPacienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sw.dw.umg.edu/", name = "consultarCoberturaPacienteResponse")
    public JAXBElement<ConsultarCoberturaPacienteResponse> createConsultarCoberturaPacienteResponse(ConsultarCoberturaPacienteResponse value) {
        return new JAXBElement<ConsultarCoberturaPacienteResponse>(_ConsultarCoberturaPacienteResponse_QNAME, ConsultarCoberturaPacienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PeticionConsultaPaciente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sw.dw.umg.edu/", name = "PeticionConsultaPaciente")
    public JAXBElement<PeticionConsultaPaciente> createPeticionConsultaPaciente(PeticionConsultaPaciente value) {
        return new JAXBElement<PeticionConsultaPaciente>(_PeticionConsultaPaciente_QNAME, PeticionConsultaPaciente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCoberturaPaciente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sw.dw.umg.edu/", name = "consultarCoberturaPaciente")
    public JAXBElement<ConsultarCoberturaPaciente> createConsultarCoberturaPaciente(ConsultarCoberturaPaciente value) {
        return new JAXBElement<ConsultarCoberturaPaciente>(_ConsultarCoberturaPaciente_QNAME, ConsultarCoberturaPaciente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProveedores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sw.dw.umg.edu/", name = "obtenerProveedores")
    public JAXBElement<ObtenerProveedores> createObtenerProveedores(ObtenerProveedores value) {
        return new JAXBElement<ObtenerProveedores>(_ObtenerProveedores_QNAME, ObtenerProveedores.class, null, value);
    }

}
