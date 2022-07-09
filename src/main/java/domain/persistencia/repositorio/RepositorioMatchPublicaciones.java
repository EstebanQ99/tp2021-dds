package domain.persistencia.repositorio;

import domain.entities.Publicaciones.MatchPublicaciones;
import domain.persistencia.daos.DAO;

public class RepositorioMatchPublicaciones extends Repositorio<MatchPublicaciones>{
    public RepositorioMatchPublicaciones(DAO<MatchPublicaciones> dao) {
        super(dao);
    }
}
