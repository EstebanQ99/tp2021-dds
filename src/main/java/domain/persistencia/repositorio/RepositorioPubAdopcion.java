package domain.persistencia.repositorio;

import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.persistencia.daos.DAO;

public class RepositorioPubAdopcion extends Repositorio<PublicacionMascotaEnAdopcion>{
    public RepositorioPubAdopcion(DAO<PublicacionMascotaEnAdopcion> dao) {
        super(dao);
    }
}
