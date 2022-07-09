package domain.entities.Publicaciones;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity(name = "publicacion")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Publicacion extends EntidadPersistente {

    @Column
    private Boolean aprobada;

    @Column(columnDefinition = "DATE")
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setAprobada(Boolean valor){aprobada=valor;}

    public Boolean getAprobada(){return aprobada;}
}
