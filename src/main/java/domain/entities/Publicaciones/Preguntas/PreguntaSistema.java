package domain.entities.Publicaciones.Preguntas;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pregSist")
public class PreguntaSistema extends EntidadPersistente {

    @Column
    private String pregunta;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}

