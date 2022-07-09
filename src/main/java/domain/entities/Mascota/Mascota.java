package domain.entities.Mascota;

import domain.entities.EntidadPersistente;
import domain.entities.usuario.Persona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mascota")
public class Mascota extends EntidadPersistente {

    @ManyToOne
    private Persona persona;

    @Column
    private String tipo;

    @Column
    private String nombre;

    @Column
    private String apodo;

    @Column
    private Integer edad;

    @Column
    private String sexo;

    @Column
    private String descripcion;

    @OneToMany
    @JoinColumn(name= "foto_id", referencedColumnName = "id")
    private final List<Foto> fotos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "mascota_id", referencedColumnName = "id")
    private final List<CaractMascota> caracteristicas;

    @Column
    private String placaQR;

    //TODO: revisar si se persiste
    @Transient
    private final UUID uuid;

    public Mascota(){
        this.fotos = new ArrayList<Foto>();
        this.caracteristicas = new ArrayList<CaractMascota>();
        this.uuid = UUID.randomUUID();
    }

    public void setNombre(String name){nombre = name;}

    public String getNombre(){return nombre;}

    public void setApodo(String apodo1){apodo = apodo1;}

    public String getApodo(){return apodo;}

    public void setTipo(String tipo1){tipo = tipo1;}

    public String getTipo() {return tipo;}

    public void setEdad(int edad1){edad = edad1;}

    public Integer getEdad() {return edad;}

    public void setDescripcion(String descrip){this.descripcion = descrip;}

    public String getDescripcion(){return descripcion;}

    public void setSexo(String s){sexo=s;}

    public String getSexo(){return sexo;}

    public void setPersona(Persona duenio1){persona = duenio1;}

    public Persona getPersona(){return persona;}

    public UUID getUuid() {return uuid;}

    public List<CaractMascota> getCaracteristicas(){return caracteristicas;}

    public void asignarCaracteristica(CaractMascota caractMascota){caracteristicas.add(caractMascota);}

    public String getPlacaQR() { return placaQR; }

    public void asignarPlacaQR() {

        //TODO Generar y asignar codigo placa qr
    }


}











