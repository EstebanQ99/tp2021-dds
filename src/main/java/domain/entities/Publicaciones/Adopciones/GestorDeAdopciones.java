package domain.entities.Publicaciones.Adopciones;

import domain.entities.Mascota.CaractMascota;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.PreguntaOrganizacion;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;
import domain.entities.usuario.Calificable;
import domain.entities.usuario.Persona;
import domain.persistencia.factories.FactoryRepositorioPubAdopcion;
import domain.persistencia.factories.FactoryRepositorioPubBusqueda;
import domain.persistencia.factories.FactoryRepositorioPubMascotaPerdida;
import domain.persistencia.repositorio.*;

import java.util.List;

public class GestorDeAdopciones {

    private final RepositorioPubAdopcion repositorioPubAdopcion;
    private final RepositorioPubMascotaPerdida repositorioPubMascotaPerdida;
    private final RepositorioPubBusqueda repositorioPubBusqueda;

    public GestorDeAdopciones(){
        this.repositorioPubAdopcion = FactoryRepositorioPubAdopcion.get();
        this.repositorioPubBusqueda = FactoryRepositorioPubBusqueda.get();
        this.repositorioPubMascotaPerdida = FactoryRepositorioPubMascotaPerdida.get();
    }

    public PublicacionMascotaEnAdopcion armarPublicacionMascotaEnAdopcion(Mascota mascota){
//      Tengo que armar el esqueleto de la public. con la mascota y las preguntas
        PublicacionMascotaEnAdopcion p = new PublicacionMascotaEnAdopcion();
        p.setMascota(mascota);

        return p;
    }

    public void completarPublicacionMascotaEnAdopcion(PublicacionMascotaEnAdopcion p){
//     TODO: Ver como agregar las respuestas que voy a recibir del formulario html

//        List<PreguntaSistema> pregSistema = new RepoPreguntasSist().obtenerListaPreguntasSist();
//        List<PreguntaOrganizacion> pregOrg = p.getMascota().getDuenio().getAsociacion().getListaPregAdopcion();
       // pregSistema.forEach(preg -> p.contestarPreguntaSistema(preg,/*faltan las respuestas*/));
       // pregOrg.forEach(preg -> p.contestarPreguntaOrganizacion(preg,/*faltan las respuestas*/));
        repositorioPubAdopcion.agregar(p);
    }

//  Corregir el armado de busqueda adopcion
    public PublicacionBusquedaAdopcion armarPublicacionBusquedaAdopcion(Persona persona, List<CaractMascota> preferencias, List<Calificable> calificables){
        PublicacionBusquedaAdopcion pub = new PublicacionBusquedaAdopcion();
        pub.setPersona(persona);
        pub.setCalificables(calificables);
        return pub;
    }

    public void eliminarPubAdopcion(PublicacionMascotaEnAdopcion pub) {repositorioPubAdopcion.eliminar(pub);}
}
