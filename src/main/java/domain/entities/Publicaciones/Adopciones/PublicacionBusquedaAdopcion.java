package domain.entities.Publicaciones.Adopciones;

import domain.entities.Mascota.CaractMascota;
import domain.entities.Publicaciones.Publicacion;
import domain.entities.usuario.Calificable;
import domain.entities.usuario.Persona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pubBusqAdop")
public class PublicacionBusquedaAdopcion extends Publicacion {

    @OneToOne
    @JoinColumn(name= "persona_id")
    private Persona persona;

    @OneToMany
    @JoinColumn(name= "pubBusqAdop_id")
    private List<CaractMascota> preferencias;

    @OneToMany
    @JoinColumn(name= "pubBusqAdop_id")
    private List<Calificable> calificables;

    public PublicacionBusquedaAdopcion() {
        preferencias = new ArrayList<>();
        calificables = new ArrayList<>();
    }

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona1) {persona=persona1;}

    public void setPreferencias(List<CaractMascota> preferencias1) {preferencias=preferencias1;}

    public void setCalificables(List<Calificable> calificables) {this.calificables=calificables;}

    public List<CaractMascota> getPreferencias() {
        return preferencias;
    }

    public List<Calificable> getCalificables() {
        return calificables;
    }
}
