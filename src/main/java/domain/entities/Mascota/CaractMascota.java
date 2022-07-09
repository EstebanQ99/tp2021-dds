package domain.entities.Mascota;


import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.Caracteristica;

import javax.persistence.*;

@Entity
@Table(name = "caractMascota")
public class CaractMascota extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name= "caracteristica_id", referencedColumnName = "id")
    private Caracteristica caracteristica;

    @Column
    private String valor;

    public void setCaracteristica(Caracteristica caract1){caracteristica = caract1;}

    public void setValor(String valor1){valor=valor1;}

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public String getValor() {
        return valor;
    }
}
