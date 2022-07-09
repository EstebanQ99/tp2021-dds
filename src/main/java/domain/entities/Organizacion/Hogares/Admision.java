package domain.entities.Organizacion.Hogares;

import domain.entities.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admision")
public class Admision extends EntidadPersistente {

    @Column
    public boolean perros;

    @Column
    public boolean gatos;

    public boolean isPerros() {
        return perros;
    }

    public void setPerros(boolean perros) {
        this.perros = perros;
    }

    public boolean isGatos() {
        return gatos;
    }

    public void setGatos(boolean gatos) {
        this.gatos = gatos;
    }
}
