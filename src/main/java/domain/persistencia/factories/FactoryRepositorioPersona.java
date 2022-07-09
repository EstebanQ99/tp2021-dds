package domain.persistencia.factories;

import config.Config;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioPersona;
import domain.persistencia.testMemoData.Data;

//import javax.xml.crypto.Data;

public class FactoryRepositorioPersona {
    private static RepositorioPersona repo;

    static {
        repo = null;
    }

    public static RepositorioPersona get() {
        if (repo == null) {
            if (Config.useDataBase) {
                DAO<Persona> dao = new DAOHibernate<>(Persona.class);
                repo = new RepositorioPersona(dao);
            } else {
                repo = new RepositorioPersona(new DAOMemoria<>(Data.getData(Usuario.class)));
            }
        }
        return repo;
    }
}