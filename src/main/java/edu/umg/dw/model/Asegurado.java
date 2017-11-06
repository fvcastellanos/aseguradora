package edu.umg.dw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the asegurado database table.
 * 
 */
@Entity
@Table(name="asegurado")
@NamedQueries({
		@NamedQuery(name="Asegurado.findAll", query="SELECT a FROM Asegurado a where a.activo = 1"),
		@NamedQuery(name="Asegurado.findById", query = "select a from Asegurado a where a.id = :id")
})

public class Asegurado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int activo;

	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private String telefono;

	//bi-directional many-to-one association to Poliza
	@OneToMany(mappedBy="asegurado")
	private List<Poliza> polizas;

	public Asegurado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActivo() {
		return this.activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Poliza> getPolizas() {
		return this.polizas;
	}

	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	public Poliza addPoliza(Poliza poliza) {
		getPolizas().add(poliza);
		poliza.setAsegurado(this);

		return poliza;
	}

	public Poliza removePoliza(Poliza poliza) {
		getPolizas().remove(poliza);
		poliza.setAsegurado(null);

		return poliza;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Asegurado asegurado = (Asegurado) o;

		if (id != asegurado.id) return false;
		if (activo != asegurado.activo) return false;
		if (fechaNacimiento != null ? !fechaNacimiento.equals(asegurado.fechaNacimiento) : asegurado.fechaNacimiento != null)
			return false;
		if (primerApellido != null ? !primerApellido.equals(asegurado.primerApellido) : asegurado.primerApellido != null)
			return false;
		if (primerNombre != null ? !primerNombre.equals(asegurado.primerNombre) : asegurado.primerNombre != null)
			return false;
		if (segundoApellido != null ? !segundoApellido.equals(asegurado.segundoApellido) : asegurado.segundoApellido != null)
			return false;
		if (segundoNombre != null ? !segundoNombre.equals(asegurado.segundoNombre) : asegurado.segundoNombre != null)
			return false;
		if (telefono != null ? !telefono.equals(asegurado.telefono) : asegurado.telefono != null) return false;
		return polizas != null ? polizas.equals(asegurado.polizas) : asegurado.polizas == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + activo;
		result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
		result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
		result = 31 * result + (primerNombre != null ? primerNombre.hashCode() : 0);
		result = 31 * result + (segundoApellido != null ? segundoApellido.hashCode() : 0);
		result = 31 * result + (segundoNombre != null ? segundoNombre.hashCode() : 0);
		result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
		result = 31 * result + (polizas != null ? polizas.hashCode() : 0);
		return result;
	}

}