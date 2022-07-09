package domain.entities.usuario;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.Organizacion;
import domain.entities.Publicaciones.Publicacion;

import javax.persistence.*;

@Entity
@Table(name = "voluntario")
public class Voluntario extends EntidadPersistente {

    @OneToOne
    @JoinColumn(name= "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void aprobarPublicacion(Publicacion publicacion) {publicacion.setAprobada(true);}

    public void bajaPublicacion(Publicacion publicacion) {publicacion.setAprobada(false);}
}
