package domain.entities.Publicaciones.MascotaPerdida;

import domain.entities.EntidadPersistente;
import domain.entities.Mascota.Foto;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Hogares.Hogar;
import domain.entities.usuario.Persona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mascotaPerdida")
public class MascotaPerdida extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name= "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    @OneToOne
    @JoinColumn(name= "persona_id", referencedColumnName = "id")
    private Persona rescatista;

    @Column
    private Boolean tieneChapita;

    @Column
    private String chapita;

    @OneToMany
    @JoinColumn(name = "foto_id", referencedColumnName = "id")
    private List<Foto> fotos;

    @Column
    private String estadoMascota;

    @OneToOne
    @JoinColumn(name= "ubicacion_id", referencedColumnName = "id")
    private Ubicacion lugarDeAparicion;

    @OneToOne
    @JoinColumn(name= "hogar_id", referencedColumnName = "id")
    private Hogar residencia;

    public MascotaPerdida(){
        this.fotos = new ArrayList<>();
    }

    public List<Foto> getFotos() {return fotos;}

    public String getEstadoMascota() {return estadoMascota;}

    public Ubicacion getLugarDeAparicion() {return lugarDeAparicion;}

    public Hogar getResidencia() {return residencia;}

    public Mascota getMascota() {return mascota;}

    public void setMascota(Mascota mascota) {this.mascota = mascota;}

    public Persona getRescatista() {return rescatista;}

    public void setRescatista(Persona rescatista) {this.rescatista = rescatista;}

    public void setFotos(List<Foto> fotos) {this.fotos = fotos;}

    public void setEstadoMascota(String estadoMascota) {this.estadoMascota = estadoMascota;}

    public void setLugarDeAparicion(Ubicacion lugarDeAparicion) {this.lugarDeAparicion = lugarDeAparicion;}

    public void setResidencia(Hogar residencia) {this.residencia = residencia;}

    public Boolean getTieneChapita() {return tieneChapita;}

    public String getChapita(){return chapita;}

    public void setTieneChapita(Boolean tieneChapita) {
        this.tieneChapita = tieneChapita;
    }

    public void setChapita(String chapita) {
        this.chapita = chapita;
    }

    public void notificarDueño(){mascota.getPersona().getContactos()
                                .forEach(contacto -> contacto.getMedioNotificacion().enviarNotificacion(contacto,"Encontre a tu mascota"));
    }

}
