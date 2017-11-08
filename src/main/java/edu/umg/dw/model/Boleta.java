package edu.umg.dw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the boleta database table.
 * 
 */
@Entity
@Table(name="boleta")
@NamedQueries({
        @NamedQuery(name="Boleta.findAll", query="SELECT b FROM Boleta b"),
        @NamedQuery(name="Boleta.boletasPoliza", query = "select b from Boleta b where b.poliza.id = :polizaId")

})
public class Boleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int anio;

	private String codigo;

	@Column(name="fecha_pago")
	private Date fechaPago;

	private int mes;

	//bi-directional many-to-one association to Poliza
	@ManyToOne
	private Poliza poliza;

	public Boleta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}