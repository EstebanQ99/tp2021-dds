package domain.persistencia.repositorio;

import db.EntityManagerHelper;
import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.BusquedaCondicional;
import domain.persistencia.daos.DAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioPersona extends Repositorio<Persona> {

    public RepositorioPersona(DAO<Persona> dao) {
        super(dao);
    }

    public Boolean existe(String nombreDeUsuario, String contrasenia){
        return buscarUsuario(nombreDeUsuario, contrasenia) != null;
    }

    public Persona buscarUsuario(String nombreDeUsuario, String contrasenia){
        return (Persona) EntityManagerHelper.createQuery("from Persona where usuario.nombreUsuario= '"+nombreDeUsuario+ "' and usuario.contrasenia ='"+ contrasenia+"'")
                .getSingleResult();
        //    return this.dao.buscar(condicionUsuarioYContrasenia(nombreDeUsuario, contrasenia));
    }

    private BusquedaCondicional condicionUsuarioYContrasenia(String nombreDeUsuario, String contrasenia){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Organizacion> usuarioQuery = criteriaBuilder.createQuery(Organizacion.class);

        Root<Organizacion> condicionRaiz = usuarioQuery.from(Organizacion.class);

        Predicate condicionNombreDeUsuario = criteriaBuilder.equal(condicionRaiz.get("usuario"), nombreDeUsuario);
        Predicate condicionContrasenia = criteriaBuilder.equal(condicionRaiz.get("contrasenia"), contrasenia);

        Predicate condicionExisteUsuario = criteriaBuilder.and(condicionNombreDeUsuario, condicionContrasenia);

        usuarioQuery.where(condicionExisteUsuario);

        return new BusquedaCondicional(null, usuarioQuery);
    }
}