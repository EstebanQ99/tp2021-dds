package domain.entities.Organizacion;

import domain.entities.EntidadPersistente;
import domain.entities.usuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class Organizacion extends EntidadPersistente {

    //TODO: revisar PK FK
    @OneToOne
    @JoinColumn(name= "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column
    private String nombre;

    @OneToOne
    private FotoNormalizacion parametrosFoto;

    @OneToMany
    @JoinColumn(name= "foto_id", referencedColumnName = "id")
    private List<Caracteristica> listaCaracteristicas;

    @OneToMany(mappedBy = "organizacion", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<PreguntaOrganizacion> listaPregAdopcion;

    public Organizacion(){
        this.listaCaracteristicas = new ArrayList<Caracteristica>();
        this.listaPregAdopcion = new ArrayList<PreguntaOrganizacion>();
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public FotoNormalizacion getParametrosFoto() {return parametrosFoto;}

    public void setParametrosFoto(FotoNormalizacion parametrosFoto) {this.parametrosFoto = parametrosFoto;}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Caracteristica> getListaCaracteristicas() {
        return listaCaracteristicas;
    }

    public void setListaCaracteristicas(List<Caracteristica> listaCaracteristicas) {
        this.listaCaracteristicas = listaCaracteristicas;
    }

    public void setListaPregAdopcion(List<PreguntaOrganizacion> listaPregAdopcion) {
        this.listaPregAdopcion = listaPregAdopcion;
    }

    public List<PreguntaOrganizacion> getListaPregAdopcion(){return listaPregAdopcion;}

    public void agregarCaractMascota(Caracteristica caracteristica){listaCaracteristicas.add(caracteristica);}

    public void quitarCaractMascota(Caracteristica caracteristica){listaCaracteristicas.remove(caracteristica);}

    public void agregarPreguntaAdopcion(PreguntaOrganizacion pregunta){listaPregAdopcion.add(pregunta);}

    public void quitarPreguntaAdopcion(PreguntaOrganizacion pregunta){listaPregAdopcion.remove(pregunta);}
}
