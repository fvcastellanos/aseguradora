
package edu.umg.dw.web.cliente.dominio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaListadoProveedores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="respuestaListadoProveedores">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sw.dw.umg.edu/}respuestaBase">
 *       &lt;sequence>
 *         &lt;element name="proveedores" type="{http://sw.dw.umg.edu/}proveedor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaListadoProveedores", propOrder = {
    "proveedores"
})
public class RespuestaListadoProveedores
    extends RespuestaBase
{

    @XmlElement(nillable = true)
    protected List<Proveedor> proveedores;

    /**
     * Gets the value of the proveedores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proveedores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProveedores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proveedor }
     * 
     * 
     */
    public List<Proveedor> getProveedores() {
        if (proveedores == null) {
            proveedores = new ArrayList<Proveedor>();
        }
        return this.proveedores;
    }

}
