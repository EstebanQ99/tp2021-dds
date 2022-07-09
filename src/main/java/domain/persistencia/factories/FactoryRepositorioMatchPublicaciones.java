package domain.persistencia.factories;

import config.Config;
import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.entities.Publicaciones.MatchPublicaciones;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioMatchPublicaciones;
import domain.persistencia.repositorio.RepositorioPubMascotaPerdida;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioMatchPublicaciones {

    private static RepositorioMatchPublicaciones repo;

    static {
        repo = null;
    }

    public static RepositorioMatchPublicaciones get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<MatchPublicaciones> dao = new DAOHibernate<>(MatchPublicaciones.class);
                repo = new RepositorioMatchPublicaciones(dao);
            } else {
                repo = new RepositorioMatchPublicaciones(new DAOMemoria<>(Data.getData(MatchPublicaciones.class)));
            }
        }
        return repo;
    }
}
