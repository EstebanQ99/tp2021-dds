package domain.entities.Organizacion;


import domain.entities.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "preguntaOrg")
public class PreguntaOrganizacion extends EntidadPersistente {

    @Column
    private String pregunta;

    @ManyToOne
//    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
