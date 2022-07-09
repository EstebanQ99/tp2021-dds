package domain.entities.usuario;

import domain.entities.EntidadPersistente;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Organizacion;
import domain.entities.Publicaciones.Adopciones.GestorDeAdopciones;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona extends EntidadPersistente {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaNac;

    @Column
    private String direccion;

    @Column
    private String tipoDoc;

    @Column
    private int nroDoc;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "caractUsuario_id", referencedColumnName = "id")
    private final List<CaracteristicaUsuario> caracteristicaUsuarios;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "contacto_id", referencedColumnName = "id")
    private final List<Contacto> contactos;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private final List<Mascota> mascotas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "comodidad_id", referencedColumnName = "id")
    private final List<Comodidad> comodidades;

    public Persona(){
        this.contactos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
        this.comodidades = new ArrayList<>();
        this.caracteristicaUsuarios = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNombre() {return nombre;}

    public String getApellido() {return apellido;}

    public LocalDate getFechaNac() {return fechaNac;}

    public String getDireccion() {return direccion;}

    public List<Contacto> getContactos(){return contactos;}

    public List<Comodidad> getComodidades() {return comodidades;}

    public List<Mascota> getMascotas() {return mascotas;}

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public List<CaracteristicaUsuario> getCaracteristicaUsuarios() {
        return caracteristicaUsuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public void setFechaNac(LocalDate fechaNac) {this.fechaNac = fechaNac;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public void setContactos(Contacto contacto){contactos.add(contacto);}

    public void registrarMascota(Mascota mascota){mascotas.add(mascota);}

   public void registrarComodidad(Comodidad c){comodidades.add(c);}

    public void quitarMascota(Mascota mascota){mascotas.remove(mascota);}

    public void recibirIntencionAdopcion(Persona usuario, Mascota mascota) {
        contactos.forEach(contacto ->
                contacto.getMedioNotificacion()
                        .enviarNotificacion(contacto,usuario.getNombre() + " " + usuario.getApellido() + "quiere adoptar a tu mascota" + mascota.getNombre()));
    }

    public void concluirAdopcion(Persona usuario, Mascota mascota,PublicacionMascotaEnAdopcion pub){
        if(mascotas.contains(mascota)){
            usuario.registrarMascota(mascota);
            mascota.setPersona(usuario);
            usuario.getContactos().forEach(contacto ->
                            contacto.getMedioNotificacion().
                            enviarNotificacion(contacto,nombre + " " + apellido + "ha confirmado la adopcion de" + mascota.getNombre()));
            quitarMascota(mascota);
            if(mascota == pub.getMascota()) {
                new GestorDeAdopciones().eliminarPubAdopcion(pub); //Eliminamos la publicacion de mascota en adopcion
            }
        }
    }
}