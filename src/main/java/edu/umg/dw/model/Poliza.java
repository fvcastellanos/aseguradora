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
@NamedQueries({
		@NamedQuery(name="Poliza.findAll", query="SELECT p FROM Poliza p"),
        @NamedQuery(name="Poliza.obtenerNumeroPoliza", query="SELECT p FROM Poliza p where p.noPoliza = :poliza"),
})
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

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="primer_nombre")
    private String primerNombre;

    @Column(name="segundo_nombre")
    private String segundoNombre;

    @Column(name="primer_apellido")
    private String primerApellido;

    @Column(name="segundo_apellido")
    private String segundoApellido;

    private String telefono;

	//bi-directional many-to-one association to Boleta
	@OneToMany(mappedBy="poliza")
	private List<Boleta> boletas;

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
}