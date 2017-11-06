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
		@NamedQuery(name="Asegurado.findAll", query="SELECT a FROM Asegurado a"),
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

	private Asegurado(Builder builder) {
		setId(builder.id);
		setActivo(builder.activo);
		setFechaNacimiento(builder.fechaNacimiento);
		setPrimerApellido(builder.primerApellido);
		setPrimerNombre(builder.primerNombre);
		setSegundoApellido(builder.segundoApellido);
		setSegundoNombre(builder.segundoNombre);
		setTelefono(builder.telefono);
		setPolizas(builder.polizas);
	}

	public static Builder newBuilder() {
		return new Builder();
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


	public static final class Builder {
		private int id;
		private int activo;
		private Date fechaNacimiento;
		private String primerApellido;
		private String primerNombre;
		private String segundoApellido;
		private String segundoNombre;
		private String telefono;
		private List<Poliza> polizas;

		private Builder() {
		}

		public Builder id(int val) {
			id = val;
			return this;
		}

		public Builder activo(int val) {
			activo = val;
			return this;
		}

		public Builder fechaNacimiento(Date val) {
			fechaNacimiento = val;
			return this;
		}

		public Builder primerApellido(String val) {
			primerApellido = val;
			return this;
		}

		public Builder primerNombre(String val) {
			primerNombre = val;
			return this;
		}

		public Builder segundoApellido(String val) {
			segundoApellido = val;
			return this;
		}

		public Builder segundoNombre(String val) {
			segundoNombre = val;
			return this;
		}

		public Builder telefono(String val) {
			telefono = val;
			return this;
		}

		public Builder polizas(List<Poliza> val) {
			polizas = val;
			return this;
		}

		public Asegurado build() {
			return new Asegurado(this);
		}
	}
}