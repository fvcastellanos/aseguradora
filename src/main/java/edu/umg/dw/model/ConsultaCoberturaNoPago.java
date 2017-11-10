package edu.umg.dw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "ConsultaCoberturaNoPago.findConsultaCoberturaNoPago",
                query = "SELECT p.id, p.no_poliza AS poliza, p.nombres, CONCAT(MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')), ' ', b.anio) AS ultimaFechaPagada, b.fecha_pago AS fechaDePago " +
                        "FROM boleta b " +
                        "JOIN poliza p ON b.poliza_id = p.id " +
                        "WHERE b.pagada = 'Y' " +
                        "AND p.id IN (SELECT p.id " +
                        "           FROM boleta b " +
                        "           JOIN poliza p ON b.poliza_id = p.id " +
                        "           WHERE b.pagada = 'N' " +
                        "           GROUP BY p.no_poliza " +
                        "           HAVING count(b.pagada) > 2) " +
                        "ORDER BY b.fecha_pago DESC " +
                        "LIMIT 1",
                resultClass = ConsultaCoberturaNoPago.class
        )
})
public class ConsultaCoberturaNoPago implements Serializable {

    @Id
    private long id;
    private String poliza;
    private String nombres;
    private String ultimaFechaPagada;
    private Date fechaDePago;

    public ConsultaCoberturaNoPago() {
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(final String poliza) {
        this.poliza = poliza;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(final String nombres) {
        this.nombres = nombres;
    }

    public String getUltimaFechaPagada() {
        return ultimaFechaPagada;
    }

    public void setUltimaFechaPagada(final String ultimaFechaPagada) {
        this.ultimaFechaPagada = ultimaFechaPagada;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(final Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

}
