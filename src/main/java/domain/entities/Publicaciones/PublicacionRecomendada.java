package domain.entities.Publicaciones;

import domain.entities.EntidadPersistente;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.entities.usuario.Persona;

import javax.persistence.*;

@Entity
@Table(name = "recomendado")
public class PublicacionRecomendada extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "pubMascEnAdop_id", referencedColumnName = "id")
    private PublicacionMascotaEnAdopcion publicacion;

    /*public PublicacionRecomendada(Persona persona, PublicacionMascotaEnAdopcion pub) {
        super();
    }*/

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PublicacionMascotaEnAdopcion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(PublicacionMascotaEnAdopcion publicacion) {
        this.publicacion = publicacion;
    }
}
