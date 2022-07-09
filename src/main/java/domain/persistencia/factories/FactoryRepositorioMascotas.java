package domain.persistencia.factories;

import config.Config;
import domain.entities.Mascota.Mascota;
import domain.persistencia.repositorio.RepositorioDeMascotas;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioMascotas {
    private static RepositorioDeMascotas repo;

    static {
        repo = null;
    }

    public static RepositorioDeMascotas get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<Mascota> dao = new DAOHibernate<>(Mascota.class);
                repo = new RepositorioDeMascotas(dao);
            } else {
                repo = new RepositorioDeMascotas(new DAOMemoria<>(Data.getData(Mascota.class)));
            }
        }
        return repo;
    }
}
