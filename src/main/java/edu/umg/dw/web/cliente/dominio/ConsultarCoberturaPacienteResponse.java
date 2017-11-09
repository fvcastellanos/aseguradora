
package edu.umg.dw.web.cliente.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarCoberturaPacienteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarCoberturaPacienteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://sw.dw.umg.edu/}respuestaConsultaCobertura" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCoberturaPacienteResponse", propOrder = {
    "_return"
})
public class ConsultarCoberturaPacienteResponse {

    @XmlElement(name = "return")
    protected RespuestaConsultaCobertura _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaConsultaCobertura }
     *     
     */
    public RespuestaConsultaCobertura getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaConsultaCobertura }
     *     
     */
    public void setReturn(RespuestaConsultaCobertura value) {
        this._return = value;
    }

}
