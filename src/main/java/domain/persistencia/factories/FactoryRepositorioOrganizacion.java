package domain.persistencia.factories;

import config.Config;
import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioOrganizacion;
import domain.persistencia.repositorio.RepositorioPersona;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioOrganizacion {
    private static RepositorioOrganizacion repo;

    static {
        repo = null;
    }

    public static RepositorioOrganizacion get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<Organizacion> dao = new DAOHibernate<>(Organizacion.class);
                repo = new RepositorioOrganizacion(dao);
            } else {
                repo = new RepositorioOrganizacion(new DAOMemoria<>(Data.getData(Organizacion.class)));
            }
        }
        return repo;
    }
}
