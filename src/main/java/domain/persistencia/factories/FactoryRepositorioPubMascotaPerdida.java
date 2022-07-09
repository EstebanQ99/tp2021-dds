package domain.persistencia.factories;

import config.Config;
import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioPubBusqueda;
import domain.persistencia.repositorio.RepositorioPubMascotaPerdida;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioPubMascotaPerdida {

    private static RepositorioPubMascotaPerdida repo;

    static {
        repo = null;
    }

    public static RepositorioPubMascotaPerdida get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<PublicacionMascotaPerdida> dao = new DAOHibernate<>(PublicacionMascotaPerdida.class);
                repo = new RepositorioPubMascotaPerdida(dao);
            } else {
                repo = new RepositorioPubMascotaPerdida(new DAOMemoria<>(Data.getData(PublicacionMascotaPerdida.class)));
            }
        }
        return repo;
    }
}
