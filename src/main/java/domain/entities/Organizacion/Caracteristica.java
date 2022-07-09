package domain.entities.Organizacion;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "caracteristica")
public class Caracteristica extends EntidadPersistente {

    @Column
    private String nombre;

    public String getNombre() {return nombre;}

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
