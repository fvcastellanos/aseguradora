package edu.umg.dw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the consulta_cobertura database table.
 * 
 */
@Entity
@Table(name="consulta_cobertura")
@NamedQuery(name="ConsultaCobertura.findAll", query="SELECT c FROM ConsultaCobertura c")
public class ConsultaCobertura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String autorizacion;

	@Column(name="fecha_consulta")
	private Date fechaConsulta;

	@Column(name="nit_proveedor")
	private String nitProveedor;

	private String poliza;

	public ConsultaCobertura() {
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

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public Date getFechaConsulta() {
		return this.fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getNitProveedor() {
		return this.nitProveedor;
	}

	public void setNitProveedor(String nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getPoliza() {
		return this.poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

}