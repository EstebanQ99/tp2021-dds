package domain.entities.Publicaciones.Preguntas;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.PreguntaOrganizacion;

import javax.persistence.*;

@Entity
@Table(name = "pregConResp")
public class PreguntaConRespuesta extends EntidadPersistente{

    @OneToOne
    @JoinColumn(name = "preguntaOrg_id", referencedColumnName = "id")
    private PreguntaOrganizacion pregunta;

    @Column
    private String respuesta;

    public PreguntaOrganizacion getPregunta() {return pregunta;}

    public void setPregunta(PreguntaOrganizacion pregunta) {this.pregunta = pregunta;}

    public String getRespuesta() {return respuesta;}

    public void setRespuesta(String respuesta) {this.respuesta = respuesta;}
}
