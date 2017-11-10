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
                name = "ConsultaCoberturaMesYAnio.findConsultaCoberturaMesYAnioPorNoPoliza",
                query = "SELECT b.anio, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"January\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS enero, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"February\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS febrero, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"March\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS marzo, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"April\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS abril, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"May\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS mayo, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"June\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS junio, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"July\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS julio, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"August\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS agosto, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"September\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS septiembre, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"October\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS octubre, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"November\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS noviembre, " +
                        "    MAX(CASE WHEN MONTHNAME(CONCAT(b.anio,'-',b.mes,'-01')) = \"December\" AND b.pagada = 'Y' THEN 'X' ELSE '-' END) AS diciembre " +
                        "FROM boleta b " +
                        "JOIN poliza p ON b.poliza_id = p.id " +
                        "WHERE p.no_poliza = ?1 " +
                        "GROUP BY b.poliza_id, b.anio " +
                        "ORDER BY b.anio DESC",
                resultClass = ConsultaCoberturaMesYAnio.class
        )
})
public class ConsultaCoberturaMesYAnio implements Serializable {

    @Id
    private long anio;
    private String enero;
    private String febrero;
    private String marzo;
    private String abril;
    private String mayo;
    private String junio;
    private String julio;
    private String agosto;
    private String septiembre;
    private String octubre;
    private String noviembre;
    private String diciembre;

    public long getAnio() {
        return anio;
    }

    public void setAnio(final long anio) {
        this.anio = anio;
    }

    public String getEnero() {
        return enero;
    }

    public void setEnero(final String enero) {
        this.enero = enero;
    }

    public String getFebrero() {
        return febrero;
    }

    public void setFebrero(final String febrero) {
        this.febrero = febrero;
    }

    public String getMarzo() {
        return marzo;
    }

    public void setMarzo(final String marzo) {
        this.marzo = marzo;
    }

    public String getAbril() {
        return abril;
    }

    public void setAbril(final String abril) {
        this.abril = abril;
    }

    public String getMayo() {
        return mayo;
    }

    public void setMayo(final String mayo) {
        this.mayo = mayo;
    }

    public String getJunio() {
        return junio;
    }

    public void setJunio(final String junio) {
        this.junio = junio;
    }

    public String getJulio() {
        return julio;
    }

    public void setJulio(final String julio) {
        this.julio = julio;
    }

    public String getAgosto() {
        return agosto;
    }

    public void setAgosto(final String agosto) {
        this.agosto = agosto;
    }

    public String getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(final String septiembre) {
        this.septiembre = septiembre;
    }

    public String getOctubre() {
        return octubre;
    }

    public void setOctubre(final String octubre) {
        this.octubre = octubre;
    }

    public String getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(final String noviembre) {
        this.noviembre = noviembre;
    }

    public String getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(final String diciembre) {
        this.diciembre = diciembre;
    }

}
