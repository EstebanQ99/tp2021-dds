package domain.persistencia.factories;

import config.Config;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioPubAdopcion;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioPubAdopcion {

    private static RepositorioPubAdopcion repo;

    static {
        repo = null;
    }

    public static RepositorioPubAdopcion get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<PublicacionMascotaEnAdopcion> dao = new DAOHibernate<>(PublicacionMascotaEnAdopcion.class);
                repo = new RepositorioPubAdopcion(dao);
            } else {
                repo = new RepositorioPubAdopcion(new DAOMemoria<>(Data.getData(PublicacionMascotaEnAdopcion.class)));
            }
        }
        return repo;
    }
}
