package domain.persistencia.repositorio;

import db.EntityManagerHelper;
import domain.entities.Mascota.Mascota;
import domain.entities.Publicaciones.MascotaPerdida.MascotaPerdida;
import domain.entities.usuario.Persona;
import domain.persistencia.daos.DAO;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeMascotas extends Repositorio<Mascota> {

    public RepositorioDeMascotas(DAO<Mascota> dao) {
        super(dao);
    }

    //TODO Resolver filtro mascotas x usuario de db
    public List<Mascota> buscarMascotasUsuario(Integer idUsuario){
        Persona persona =(Persona) EntityManagerHelper.createQuery("from Persona where usuario.id = "+idUsuario)
                .getSingleResult();
        return EntityManagerHelper.createQuery("from Mascota where persona.id ="+ persona.getId())
                .getResultList();
    }

    public List<Mascota> mascotasUsuario(String usuario){
        return new ArrayList<>();
    }

    public Mascota buscarPorQR(String codigoQR) {
        //TODO: Crear criteria para poder comparar al buscar DENTRO de la base de datos
        return new Mascota();
    }
    public void generarPublicacion(MascotaPerdida mascotaPerdida){

    }

}