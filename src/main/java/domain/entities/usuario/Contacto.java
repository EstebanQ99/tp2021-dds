package domain.entities.usuario;

import domain.entities.EntidadPersistente;
import domain.entities.usuario.MediosNotificacion.MedioNotificacion;

import javax.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto extends EntidadPersistente {

    @Column
    private String nombreYApellido;

    @Column
    private Integer telefono;

    @Column
    private String email;

    //TODO: revisar relacion
    @Transient
    private MedioNotificacion medioNotificacion;

    public MedioNotificacion getMedioNotificacion() {return medioNotificacion;}

    public String getEmail(){return email;}

    public void setMedioNotificacion(MedioNotificacion medioNotificacion1){medioNotificacion = medioNotificacion1;}

    public void setEmail(String email1){email = email1;}

    public void setTelefono(Integer tel) {telefono = tel;}

    public Integer getTelefono() {
        return telefono;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }
}
