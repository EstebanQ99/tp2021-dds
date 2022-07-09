package domain.entities.Publicaciones.MascotaPerdida;

import domain.entities.Publicaciones.Publicacion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pubMascotaPerdida")
public class PublicacionMascotaPerdida extends Publicacion {

    @OneToOne
    @JoinColumn(name= "mascotaPerdida_id", referencedColumnName = "id")
    private MascotaPerdida mascotaPerdida;

    public MascotaPerdida getMascotaPerdida() {return mascotaPerdida;}

    public void setMascotaPerdida(MascotaPerdida mascotaPerdida) {this.mascotaPerdida = mascotaPerdida;}
}
