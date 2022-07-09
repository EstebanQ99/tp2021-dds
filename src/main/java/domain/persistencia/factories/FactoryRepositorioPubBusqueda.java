package domain.persistencia.factories;

import config.Config;
import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.persistencia.daos.DAO;
import domain.persistencia.daos.DAOHibernate;
import domain.persistencia.daos.DAOMemoria;
import domain.persistencia.repositorio.RepositorioPubBusqueda;
import domain.persistencia.testMemoData.Data;

public class FactoryRepositorioPubBusqueda {

    private static RepositorioPubBusqueda repo;

       static {
           repo = null;
       }

       public static RepositorioPubBusqueda get() {
           if (repo == null) {
               if (Config.useDataBase) {
                   DAO<PublicacionBusquedaAdopcion> dao = new DAOHibernate<>(PublicacionBusquedaAdopcion.class);
                   repo = new RepositorioPubBusqueda(dao);
               } else {
                   repo = new RepositorioPubBusqueda(new DAOMemoria<>(Data.getData(PublicacionBusquedaAdopcion.class)));
               }
           }
           return repo;
    }
}