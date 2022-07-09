package domain.entities.Organizacion;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "fotoNormal")
public class FotoNormalizacion extends EntidadPersistente {

    @Column
    private Integer altoEstandar;

    @Column
    private Integer anchoEstandar;

    @Column
    private String calidadEstandar;

    public Integer getAltoEstandar() { return altoEstandar; }

    public Integer getAnchoEstandar() { return anchoEstandar; }

    public String getCalidadEstandar() { return calidadEstandar; }

    public void setAltoEstandar(Integer altoEstandar) {
        this.altoEstandar = altoEstandar;
    }

    public void setAnchoEstandar(Integer anchoEstandar) {
        this.anchoEstandar = anchoEstandar;
    }

    public void setCalidadEstandar(String calidadEstandar) {
        this.calidadEstandar = calidadEstandar;
    }
}
