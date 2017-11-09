package edu.umg.dw.sw.vistas;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.Date;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlAccessorType(FIELD)
@XmlRootElement(name = "PeticionConsultaPaciente")
public class PeticionConsultaPaciente {

    @XmlElement(name = "nitProveedor", required = true)
    private String nitProveedor;

    @XmlElement(name = "noPoliza", required = true)
    private String noPoliza;

    @XmlElement(name = "fechaNacimientoPaciente", required = true)
    @XmlSchemaType(name = "date")
    private Date fechaNacimientoPaciente;

    public PeticionConsultaPaciente() {
    }

    public PeticionConsultaPaciente(final String nitProveedor, final String noPoliza, final Date fechaNacimientoPaciente) {
        this.nitProveedor = nitProveedor;
        this.noPoliza = noPoliza;
        this.fechaNacimientoPaciente = fechaNacimientoPaciente;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public Date getFechaNacimientoPaciente() {
        return fechaNacimientoPaciente;
    }

}
