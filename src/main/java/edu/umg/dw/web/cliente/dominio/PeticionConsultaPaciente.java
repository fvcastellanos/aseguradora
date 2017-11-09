
package edu.umg.dw.web.cliente.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for peticionConsultaPaciente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="peticionConsultaPaciente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nitProveedor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="noPoliza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaNacimientoPaciente" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "peticionConsultaPaciente", propOrder = {
    "nitProveedor",
    "noPoliza",
    "fechaNacimientoPaciente"
})
public class PeticionConsultaPaciente {

    @XmlElement(required = true)
    protected String nitProveedor;
    @XmlElement(required = true)
    protected String noPoliza;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaNacimientoPaciente;

    /**
     * Gets the value of the nitProveedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitProveedor() {
        return nitProveedor;
    }

    /**
     * Sets the value of the nitProveedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitProveedor(String value) {
        this.nitProveedor = value;
    }

    /**
     * Gets the value of the noPoliza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoPoliza() {
        return noPoliza;
    }

    /**
     * Sets the value of the noPoliza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoPoliza(String value) {
        this.noPoliza = value;
    }

    /**
     * Gets the value of the fechaNacimientoPaciente property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNacimientoPaciente() {
        return fechaNacimientoPaciente;
    }

    /**
     * Sets the value of the fechaNacimientoPaciente property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNacimientoPaciente(XMLGregorianCalendar value) {
        this.fechaNacimientoPaciente = value;
    }

}
