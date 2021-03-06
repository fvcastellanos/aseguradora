package edu.umg.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the consulta_cobertura database table.
 */
@Entity
@Table(name = "consulta_cobertura")
@NamedQuery(name = "ConsultaCobertura.findAll", query = "SELECT c FROM ConsultaCobertura c LEFT JOIN c.poliza p ORDER BY c.fechaConsulta DESC")
public class ConsultaCobertura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String autorizacion;

    @Column(name = "fecha_consulta")
    private Date fechaConsulta;

    @Column(name = "nit_proveedor")
    private String nitProveedor;

    @ManyToOne
    @JoinColumn(name = "poliza", referencedColumnName = "no_poliza", nullable = false)
    private Poliza poliza;

    public ConsultaCobertura() {
    }

    public ConsultaCobertura(final String autorizacion, final Date fechaConsulta, final String nitProveedor, final Poliza poliza) {
        this.autorizacion = autorizacion;
        this.fechaConsulta = fechaConsulta;
        this.nitProveedor = nitProveedor;
        this.poliza = poliza;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutorizacion() {
        return this.autorizacion;
    }

    public void setAutorizacion(final String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Date getFechaConsulta() {
        return this.fechaConsulta;
    }

    public void setFechaConsulta(final Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getNitProveedor() {
        return this.nitProveedor;
    }

    public void setNitProveedor(final String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Poliza getPoliza() {
        return this.poliza;
    }

    public void setPoliza(final Poliza poliza) {
        this.poliza = poliza;
    }

}
