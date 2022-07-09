package domain.persistencia.repositorio;

import db.EntityManagerHelper;
import domain.entities.Publicaciones.*;
import domain.persistencia.daos.DAO;

import javax.persistence.*;
import java.util.List;

public class RepositorioPaginado extends Repositorio<Publicacion> {

    public RepositorioPaginado(DAO<Publicacion> dao) {
        super(dao);
    }

    public List<Publicacion> paginarPublicaciones(){
        Query pagina = EntityManagerHelper.createQuery("From Publicacion")
                .setFirstResult(0).setMaxResults(2);

        /*int cantidadDePaginas = 2;
        int cantidadDePublicacionesPorPagina = 5;

        pagina.setFirstResult((cantidadDePaginas-1) * cantidadDePublicacionesPorPagina);
        pagina.setMaxResults(cantidadDePublicacionesPorPagina);
        */
        return pagina.getResultList();
    }

}
