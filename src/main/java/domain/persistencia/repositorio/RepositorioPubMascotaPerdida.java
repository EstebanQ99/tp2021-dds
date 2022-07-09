package domain.persistencia.repositorio;

import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.persistencia.daos.DAO;

public class RepositorioPubMascotaPerdida extends Repositorio<PublicacionMascotaPerdida> {

    public RepositorioPubMascotaPerdida(DAO<PublicacionMascotaPerdida> dao) {
        super(dao);
    }
}
