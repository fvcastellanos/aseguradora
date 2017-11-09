
package edu.umg.dw.web.cliente.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarCoberturaPaciente complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarCoberturaPaciente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="peticionConsultaPaciente" type="{http://sw.dw.umg.edu/}peticionConsultaPaciente" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCoberturaPaciente", propOrder = {
    "peticionConsultaPaciente"
})
public class ConsultarCoberturaPaciente {

    protected PeticionConsultaPaciente peticionConsultaPaciente;

    /**
     * Gets the value of the peticionConsultaPaciente property.
     * 
     * @return
     *     possible object is
     *     {@link PeticionConsultaPaciente }
     *     
     */
    public PeticionConsultaPaciente getPeticionConsultaPaciente() {
        return peticionConsultaPaciente;
    }

    /**
     * Sets the value of the peticionConsultaPaciente property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeticionConsultaPaciente }
     *     
     */
    public void setPeticionConsultaPaciente(PeticionConsultaPaciente value) {
        this.peticionConsultaPaciente = value;
    }

}
