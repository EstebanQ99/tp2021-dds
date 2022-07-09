package domain.persistencia.repositorio;

import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.entities.usuario.Persona;
import domain.persistencia.daos.DAO;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioPubBusqueda extends Repositorio<PublicacionBusquedaAdopcion> {

    public RepositorioPubBusqueda(DAO<PublicacionBusquedaAdopcion> dao) {
        super(dao);
    }

    //TODO: usar esta funcion en el recomendadorAdopcion para delegar
    public List<PublicacionBusquedaAdopcion> buscarPublicacionesXPersona(Persona persona){
        List<PublicacionBusquedaAdopcion> listaPub = this.buscarTodos()
                .stream()
                .filter(pub -> pub.getPersona().equals(persona))
                .collect(Collectors.toList());
        return listaPub;
    }
}
