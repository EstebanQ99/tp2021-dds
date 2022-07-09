package domain.persistencia.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.Mascota.CaractMascota;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Caracteristica;
import domain.entities.Organizacion.PreguntaOrganizacion;
import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.entities.Publicaciones.MascotaPerdida.MascotaPerdida;
import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.entities.Publicaciones.Preguntas.PreguntaAdopcionSistema;
import domain.entities.Publicaciones.Preguntas.PreguntaConRespuesta;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;
import domain.entities.Publicaciones.Publicacion;
import domain.entities.usuario.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataPublicaciones {

    private static List<Publicacion> publicaciones = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(publicaciones.size() == 0) {

        }
        return (List<EntidadPersistente>)(List<?>) publicaciones;
    }

    private static void addAll(Publicacion ... publicaciones){
        Collections.addAll(DataPublicaciones.publicaciones, publicaciones);
    }
}
