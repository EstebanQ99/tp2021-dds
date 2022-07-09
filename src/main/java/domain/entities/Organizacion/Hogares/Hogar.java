package domain.entities.Organizacion.Hogares;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.Caracteristica;
import domain.entities.Publicaciones.MascotaPerdida.Ubicacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hogar")
public class Hogar extends EntidadPersistente {

    @Column
    public String nombre;

    @Column
    public int telefono;

    @OneToOne
    public Ubicacion ubicacion;

    @OneToOne
    public Admision admisiones;

    @Column
    public int capacidad;

    @Column
    public int lugares_disponibles;

    @Column
    public boolean patio;

    //TODO: parece que el hogar se trae una lista de caracteristicas que no es la misma que nosotros tenemos de org
    @Transient
    public List<Caracteristica> caracteristicas;

    public Hogar(){
        this.caracteristicas = new ArrayList<Caracteristica>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Admision getAdmisiones() {
        return admisiones;
    }

    public void setAdmisiones(Admision admisiones) {
        this.admisiones = admisiones;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getLugares_disponibles() {
        return lugares_disponibles;
    }

    public void setLugares_disponibles(int lugares_disponibles) {
        this.lugares_disponibles = lugares_disponibles;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
