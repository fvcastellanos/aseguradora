package edu.umg.dw.servicios.dominio;

import com.google.common.collect.Lists;
import edu.umg.dw.model.Boleta;
import edu.umg.dw.model.Poliza;

import java.util.List;

public class ContextoPoliza {
    private String noPoliza;
    private Poliza poliza;
    private Poliza polizaModificada;
    private List<Boleta> boletas;
    private Boleta boleta;
    private int mes;
    private int anio;

    public ContextoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
        boletas = Lists.newArrayList();
    }

    public String getNoPoliza() {
        return noPoliza;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public List<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<Boleta> boletas) {
        this.boletas = boletas;
    }

    public void setNoPoliza(String noPoliza) {
        this.noPoliza = noPoliza;
    }

    public Poliza getPolizaModificada() {
        return polizaModificada;
    }

    public void setPolizaModificada(Poliza polizaModificada) {
        this.polizaModificada = polizaModificada;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
