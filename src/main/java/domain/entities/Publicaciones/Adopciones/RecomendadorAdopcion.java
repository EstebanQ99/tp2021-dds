package domain.entities.Publicaciones.Adopciones;

import domain.entities.Publicaciones.MatchPublicaciones;
import domain.entities.Publicaciones.PublicacionRecomendada;
import domain.entities.usuario.Persona;
import domain.persistencia.factories.FactoryRepositorioMatchPublicaciones;
import domain.persistencia.factories.FactoryRepositorioPubAdopcion;
import domain.persistencia.factories.FactoryRepositorioPubBusqueda;
import domain.persistencia.repositorio.RepositorioMatchPublicaciones;
import domain.persistencia.repositorio.RepositorioPubAdopcion;
import domain.persistencia.repositorio.RepositorioPubBusqueda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendadorAdopcion {
    private final RepositorioPubAdopcion repoPubAdopcion;
    private final RepositorioPubBusqueda repoPubBusqueda;
    private final RepositorioMatchPublicaciones repoMatchPublicaciones;

    public RecomendadorAdopcion(){
        this.repoPubAdopcion = FactoryRepositorioPubAdopcion.get();
        this.repoPubBusqueda = FactoryRepositorioPubBusqueda.get();
        this.repoMatchPublicaciones = FactoryRepositorioMatchPublicaciones.get();
    }

    //Hecha para procesar una sola publicacion por persona
    public ArrayList<PublicacionMascotaEnAdopcion> publicacionesRecomendadas(Persona persona){
        List<PublicacionBusquedaAdopcion> publicacionesPersona = obtenerPublicacionesBusquedaAdopcion()
                .stream()
                .filter(pub -> pub.getPersona().equals(persona))
                .collect(Collectors.toList());
        ArrayList<PublicacionMascotaEnAdopcion> publicacionesRecomendadas = new ArrayList<>();

        if(!publicacionesPersona.isEmpty()){
            //Solo tomo una publicacion
            PublicacionBusquedaAdopcion pubPersona = publicacionesPersona.get(0);

            //Obtengo los match que coincidan en pref y/o comodidades con la pubBusqAdop
            List<MatchPublicaciones> listaMatchsParciales = obtenerMatchPublicaciones()
                    .stream()
                    .filter(match -> match.tengoElMismoCalificable(pubPersona.getCalificables()) || match.tengoLaMismaPreferencia(pubPersona.getPreferencias()))
                    .collect(Collectors.toList());
            List<PublicacionMascotaEnAdopcion> pubMascotasCandidatas = obtenerPublicacionesMascotaEnAdopcion();

            if(!pubMascotasCandidatas.isEmpty() || !listaMatchsParciales.isEmpty()){
                pubMascotasCandidatas.forEach(pub -> {
                    long iteracionesMatchs = listaMatchsParciales.size();

                    //Sistema de puntaje basico
                    double puntaje = (double) listaMatchsParciales.stream()
                            .filter(match -> match.tengoLaMismaPregAdop(pub.getPreguntasSistema())
                                    || match.tengoLaMismaPregSist(pub.getPreguntasOrganizacion()))
                            .count(); //El ide me dio esta solucion en vez del forEach() de matchs, wtf??

                    if (superaMinimoScore(puntaje, iteracionesMatchs)){
                        publicacionesRecomendadas.add(pub);
                    }
                });
            }
        }
        return publicacionesRecomendadas;
    }

    private boolean superaMinimoScore(double puntaje, long iteracionesMatchs) {
        //la cantidad de aciertos de los matchs es mayor o igual al 50%
        double valor = 0.5;
        return (puntaje / iteracionesMatchs) >= valor;
    }

    public List<MatchPublicaciones> obtenerMatchPublicaciones(){
        return repoMatchPublicaciones.buscarTodos();
    }

    public List<PublicacionMascotaEnAdopcion> obtenerPublicacionesMascotaEnAdopcion(){
        return repoPubAdopcion.buscarTodos();
    }

    public List<PublicacionBusquedaAdopcion> obtenerPublicacionesBusquedaAdopcion(){
        return repoPubBusqueda.buscarTodos();
    }

    public List<PublicacionRecomendada> obtenerRecomendacionesPorPersona(Persona persona){
        List<PublicacionMascotaEnAdopcion> publicaciones = publicacionesRecomendadas(persona);
        return publicaciones.stream().map(pub -> {
            PublicacionRecomendada pubAux = new PublicacionRecomendada();
            pubAux.setPersona(persona);
            pubAux.setPublicacion(pub);
            return pubAux;
        }).collect(Collectors.toList());
    }

    public List<PublicacionRecomendada> obtenerTodasLasRecomendaciones(){
        List<PublicacionBusquedaAdopcion> listaPublicaciones = obtenerPublicacionesBusquedaAdopcion();
        List<PublicacionRecomendada> listaRecomendaciones;

        listaRecomendaciones = listaPublicaciones.stream()
                .map(pub -> obtenerRecomendacionesPorPersona(pub.getPersona()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return listaRecomendaciones;
    }
}