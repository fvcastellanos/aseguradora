
package edu.umg.dw.web.cliente.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaConsultaCobertura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaConsultaCobertura">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sw.dw.umg.edu/}respuestaBase">
 *       &lt;sequence>
 *         &lt;element name="consultaCobertura" type="{http://sw.dw.umg.edu/}consultaCobertura" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaConsultaCobertura", propOrder = {
    "consultaCobertura"
})
public class RespuestaConsultaCobertura
    extends RespuestaBase
{

    protected ConsultaCobertura consultaCobertura;

    /**
     * Gets the value of the consultaCobertura property.
     * 
     * @return
     *     possible object is
     *     {@link ConsultaCobertura }
     *     
     */
    public ConsultaCobertura getConsultaCobertura() {
        return consultaCobertura;
    }

    /**
     * Sets the value of the consultaCobertura property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsultaCobertura }
     *     
     */
    public void setConsultaCobertura(ConsultaCobertura value) {
        this.consultaCobertura = value;
    }

}
