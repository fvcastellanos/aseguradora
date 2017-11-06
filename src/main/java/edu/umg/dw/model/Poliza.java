package edu.umg.dw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the poliza database table.
 * 
 */
@Entity
@Table(name="poliza")
@NamedQuery(name="Poliza.findAll", query="SELECT p FROM Poliza p")
public class Poliza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int activa;

	@Column(name="fecha_emision")
	private Date fechaEmision;

	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	private double monto;

	@Column(name="no_pagos")
	private int noPagos;

	@Column(name="no_poliza")
	private String noPoliza;

	private String tipo;

	//bi-directional many-to-one association to Boleta
	@OneToMany(mappedBy="poliza")
	private List<Boleta> boletas;

	//bi-directional many-to-one association to Asegurado
	@ManyToOne
	private Asegurado asegurado;

	public Poliza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActiva() {
		return this.activa;
	}

	public void setActiva(int activa) {
		this.activa = activa;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getNoPagos() {
		return this.noPagos;
	}

	public void setNoPagos(int noPagos) {
		this.noPagos = noPagos;
	}

	public String getNoPoliza() {
		return this.noPoliza;
	}

	public void setNoPoliza(String noPoliza) {
		this.noPoliza = noPoliza;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Boleta> getBoletas() {
		return this.boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Boleta addBoleta(Boleta boleta) {
		getBoletas().add(boleta);
		boleta.setPoliza(this);

		return boleta;
	}

	public Boleta removeBoleta(Boleta boleta) {
		getBoletas().remove(boleta);
		boleta.setPoliza(null);

		return boleta;
	}

	public Asegurado getAsegurado() {
		return this.asegurado;
	}

	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}

}