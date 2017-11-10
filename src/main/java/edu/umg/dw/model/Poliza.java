package edu.umg.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the poliza database table.
 */
@Entity
@Table(name = "poliza")
@NamedQueries( {
                       @NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p"),
                       @NamedQuery(name = "Poliza.obtenerPorId", query = "SELECT p FROM Poliza p where p.id = :id"),
                       @NamedQuery(name = "Poliza.obtenerNumeroPoliza", query = "SELECT p FROM Poliza p where p.noPoliza = :poliza"),
                       @NamedQuery(name = "Poliza.obtenerNumeroPolizaWS", query = "SELECT p FROM Poliza p WHERE p.noPoliza = :noPoliza AND p.fechaNacimiento = :fechaNacimiento"),
               })
public class Poliza implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int activa;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    private double monto;

    @Column(name = "no_pagos")
    private int noPagos;

    @Column(name = "no_poliza")
    private String noPoliza;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    private String telefono;

    @OneToMany(mappedBy = "poliza")
    private List<ConsultaCobertura> consultaCoberturas;

    public Poliza() {
        this.noPagos = 1;
        this.activa = 1;
    }

    public Poliza(final String noPoliza) {
        this.noPoliza = noPoliza;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<ConsultaCobertura> getConsultaCoberturas() {
        return consultaCoberturas;
    }

    public void setConsultaCoberturas(final List<ConsultaCobertura> consultaCoberturas) {
        this.consultaCoberturas = consultaCoberturas;
    }
}
