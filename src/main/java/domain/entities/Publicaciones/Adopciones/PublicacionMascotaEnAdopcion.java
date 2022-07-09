package domain.entities.Publicaciones.Adopciones;

import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.PreguntaOrganizacion;
import domain.entities.Publicaciones.Preguntas.PreguntaAdopcionSistema;
import domain.entities.Publicaciones.Preguntas.PreguntaConRespuesta;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;
import domain.entities.Publicaciones.Publicacion;
import domain.entities.usuario.Persona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pubMascEnAdop")
public class PublicacionMascotaEnAdopcion extends Publicacion {

    @OneToMany
    @JoinColumn(name = "pubMascEnAdop_id", referencedColumnName = "id")
    private List<PreguntaAdopcionSistema> preguntasSistema;

    @OneToMany
    @JoinColumn(name = "pubMascEnAdop_id", referencedColumnName = "id")
    private List<PreguntaConRespuesta> preguntasOrganizacion;

    @OneToOne
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    public PublicacionMascotaEnAdopcion(){
        preguntasOrganizacion = new ArrayList<>();
        preguntasSistema = new ArrayList<>();
    }

    public List<PreguntaAdopcionSistema> getPreguntasSistema() {return preguntasSistema;}

    public List<PreguntaConRespuesta> getPreguntasOrganizacion() {return preguntasOrganizacion;}

    public Mascota getMascota() {return mascota;}

    public void setMascota(Mascota mascota) {this.mascota = mascota;}

    public void setPreguntasSistema(List<PreguntaAdopcionSistema> preguntasSistema) {
        this.preguntasSistema = preguntasSistema;
    }

    public void setPreguntasOrganizacion(List<PreguntaConRespuesta> preguntasOrganizacion) {
        this.preguntasOrganizacion = preguntasOrganizacion;
    }

    public void contestarPreguntaOrganizacion(PreguntaOrganizacion pregunta, String respuesta){
        PreguntaConRespuesta p = new PreguntaConRespuesta();
        p.setPregunta(pregunta);
        p.setRespuesta(respuesta);
        preguntasOrganizacion.add(p);
    }

    public void contestarPreguntaSistema(PreguntaSistema pregunta, String respuesta){
        PreguntaAdopcionSistema p = new PreguntaAdopcionSistema();
        p.setPregunta(pregunta);
        p.setRespuesta(respuesta);
        preguntasSistema.add(p);
    }

    public void quieroAdoptarATuMascota(Persona usuario){
        mascota.getPersona().recibirIntencionAdopcion(usuario,mascota);
    }
}
