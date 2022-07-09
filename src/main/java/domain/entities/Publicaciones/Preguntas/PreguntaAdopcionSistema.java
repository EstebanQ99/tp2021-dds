package domain.entities.Publicaciones.Preguntas;

import domain.entities.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "pregAdopSist")
public class PreguntaAdopcionSistema extends EntidadPersistente{

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pregSist_id", referencedColumnName = "id")
    private PreguntaSistema pregunta;

    @Column
    private String respuesta;

    public PreguntaSistema getPregunta() {return pregunta;}

    public void setPregunta(PreguntaSistema pregunta) {this.pregunta = pregunta;}

    public String getRespuesta() {return respuesta;}

    public void setRespuesta(String respuesta) {this.respuesta = respuesta;}
}
