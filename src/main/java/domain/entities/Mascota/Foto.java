package domain.entities.Mascota;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.FotoNormalizacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto extends EntidadPersistente {

    @Column
    private Integer alto;

    @Column
    private Integer ancho;

    @Column
    private String calidad;

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void normalizarFoto(FotoNormalizacion foto){
        alto = foto.getAltoEstandar();
        ancho = foto.getAnchoEstandar();
        calidad = foto.getCalidadEstandar();
    }
}
