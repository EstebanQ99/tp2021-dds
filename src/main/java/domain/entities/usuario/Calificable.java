package domain.entities.usuario;

import domain.entities.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@Entity(name = "calificable")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Calificable extends EntidadPersistente {
}
