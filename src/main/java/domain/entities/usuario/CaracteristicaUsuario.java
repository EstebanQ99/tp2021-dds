package domain.entities.usuario;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caractUsuario")
public class CaracteristicaUsuario extends Calificable {

    @Column
    private String nombre;

    public void setNombre(String nombre){this.nombre = nombre;}

    public String getNombre(){return this.nombre;}
}
