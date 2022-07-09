package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Organizacion;
import domain.entities.Organizacion.PreguntaOrganizacion;
import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.entities.Publicaciones.Adopciones.RecomendadorAdopcion;
import domain.entities.Publicaciones.MascotaPerdida.MascotaPerdida;
import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;
import domain.entities.Publicaciones.Publicacion;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.repositorio.Repositorio;
import domain.persistencia.repositorio.RepositorioPersona;
import domain.persistencia.repositorio.RepositorioPaginado;
import domain.persistencia.factories.FactoryRepositorio;
import domain.persistencia.factories.FactoryRepositorioPersona;
import domain.persistencia.repositorio.RepositorioPubAdopcion;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicacionesController extends AuthControllers{
    private Repositorio<Persona> repoPersona;
    private Repositorio<Publicacion> repoPublicaciones;
    private Repositorio<PreguntaSistema> repoPreguntaSistema;
    private Repositorio<PreguntaOrganizacion> repoPreguntaOrganizacion;
    private RepositorioPaginado repoPaginado;

    private RecomendadorAdopcion recomendadorAdopcion;
    private RepositorioPersona repoUsuario;
    private Repositorio<Organizacion> repoOrganizacion;

    public PublicacionesController(){
        this.repoPublicaciones = FactoryRepositorio.get(Publicacion.class);
        this.repoPreguntaSistema = FactoryRepositorio.get(PreguntaSistema.class);
        this.repoPreguntaOrganizacion = FactoryRepositorio.get(PreguntaOrganizacion.class);
        this.repoPersona = FactoryRepositorio.get(Persona.class);
        this.recomendadorAdopcion = new RecomendadorAdopcion();
        this.repoUsuario = FactoryRepositorioPersona.get();
        this.repoOrganizacion = FactoryRepositorio.get(Organizacion.class);
    }

//    private void asignarUsuarioSiEstaLogueado(Request request, Map<String, Object> parametros){
//        if(!request.session().isNew() && request.session().attribute("id") != null){
//            Persona persona = repoPersona.buscar(request.session().attribute("id"));
//            Organizacion admin = repoOrganizacion.buscar(request.session().attribute("id"));
//            if( persona != null){
//                parametros.put("persona", persona);
//            }
//            else if( admin != null){
//                parametros.put("organizacion", admin);
//            }
////            else {
////                parametros.put("usuario", usuario);
////            }
//
//        }
//    }

    public ModelAndView mostrarPublicaciones(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List publicaciones;
        Query query;
        Query query2;
        List publicacionesRecomendadas;
        String tipoFiltro = request.queryParams("tipo");
        String nroPag = request.queryParams("page");
        if(!request.session().isNew() && request.session().attribute("id") != null){
            query2 = EntityManagerHelper.createQuery("From PublicacionRecomendada where persona.usuario.id="+
                    request.session().attribute("id"));
            publicacionesRecomendadas = query2.getResultList();
            parametros.put("pubRecomendadas",publicacionesRecomendadas);
        }
        int page;
        if(nroPag != null){
            page = new Integer(nroPag);
            if(page < 1){
                page = 1;
            }
        }else{
            page = 1;
        }
        int cantMaxPublicacionesXPag = 2;

        if(tipoFiltro != null){
            switch (tipoFiltro){
                case "pubMascotaEnAdopcion":
                    query = EntityManagerHelper.createQuery("From PublicacionMascotaEnAdopcion");
                    query.setFirstResult((page - 1)*cantMaxPublicacionesXPag).setMaxResults(cantMaxPublicacionesXPag);
                    publicaciones = query.getResultList();
                    break;
                case "pubMascotaPerdida":
                    query = EntityManagerHelper.createQuery("From PublicacionMascotaPerdida");
                    query.setFirstResult((page - 1)*cantMaxPublicacionesXPag).setMaxResults(cantMaxPublicacionesXPag);
                    publicaciones = query.getResultList();
                    break;
                case "pubBusquedaAdopcion":
                    query = EntityManagerHelper.createQuery("From PublicacionBusquedaAdopcion");
                    query.setFirstResult((page - 1)*cantMaxPublicacionesXPag).setMaxResults(cantMaxPublicacionesXPag);
                    publicaciones = query.getResultList();
                    break;
                default:
                    tipoFiltro = "pubMascotaEnAdopcion";
                    query = EntityManagerHelper.createQuery("From PublicacionMascotaEnAdopcion");
                    query.setFirstResult((page - 1)*cantMaxPublicacionesXPag).setMaxResults(cantMaxPublicacionesXPag);
                    publicaciones = query.getResultList();
                    break;
            }
        }else{
            tipoFiltro = "pubMascotaEnAdopcion";
            query = EntityManagerHelper.createQuery("From PublicacionMascotaEnAdopcion");
            query.setFirstResult((page - 1)*cantMaxPublicacionesXPag).setMaxResults(cantMaxPublicacionesXPag);
            publicaciones = query.getResultList();
        }
        parametros.put(tipoFiltro, publicaciones);
        asignarUsuarioSiEstaLogueado(request, parametros);
        return new ModelAndView(parametros, "index2.hbs");
    }

    public ModelAndView mostrarRecomendaciones(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        /*int id_request = request.session().
        Query query2;
        List publicacionesRecomendadas;
        //Obtengo las publicacionesRecomendadas
        query2 = EntityManagerHelper.createQuery("From PublicacionRecomendada P where P.persona.usuario.id="+id_request);
        publicacionesRecomendadas = query2.getResultList();
        parametros.put("pubRecomendadas",publicacionesRecomendadas);*/
        List<Publicacion> publicaciones = /*this.recomendadorAdopcion.recomendar()*/ new ArrayList<>();
        parametros.put("publicaciones", publicaciones);
        return new ModelAndView(parametros, "recomendaciones.hbs");
    }

    private void asignarAtributosA(PublicacionMascotaPerdida publicacion, Request request){
        //TODO Settear atributos de MascotaPerdida

        if(request.queryParams("mascotaPerdida") != null){
            MascotaPerdida mascotaPerdida = new MascotaPerdida();
            mascotaPerdida.setEstadoMascota(request.queryParams("estadoMascota"));

            publicacion.setMascotaPerdida(mascotaPerdida);
        }
    }

    private void asignarAtributosA(PublicacionMascotaEnAdopcion publicacion, Request request){
        //TODO Settear preguntas

        if(request.queryParams("mascota") != null){
            Repositorio<Mascota> repoMascota = FactoryRepositorio.get(Mascota.class);
            Mascota mascota = repoMascota.buscar(new Integer(request.queryParams("mascota")));

            publicacion.setMascota(mascota);
        }

    }

    private void asignarAtributosA(PublicacionBusquedaAdopcion publicacion, Request request){
        //TODO Settear prefer y comodidad

        if(request.queryParams("persona") != null){
            Repositorio<Persona> repoPersona = FactoryRepositorio.get(Persona.class);
            Persona persona = repoPersona.buscar(new Integer(request.queryParams("persona")));

            publicacion.setPersona(persona);
        }
    }

    public ModelAndView mascotaPerdida(Request request,Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "mascota_perdida.hbs");
    }

    public ModelAndView mascotaPerdidaFoto(Request request,Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "mascota_perdida_foto.hbs");
    }

    public ModelAndView darEnAdopcion(Request request,Response response){
        Map<String, Object> parametros = new HashMap<>();
        List<PreguntaSistema> preguntasSistema = this.repoPreguntaSistema.buscarTodos();
        List<PreguntaOrganizacion> preguntasOrganizacion = this.repoPreguntaOrganizacion.buscarTodos();
        parametros.put("publicaciones", preguntasSistema);
        parametros.put("publicaciones", preguntasOrganizacion);
        return new ModelAndView(parametros, "dar_en_adopcion.hbs");
    }

    public ModelAndView intencionAdopcion(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "intencion_adopcion.hbs");
    }

    public Response guardarMascotaPerdida(Request request, Response response){
        PublicacionMascotaPerdida publicacion = new PublicacionMascotaPerdida();
        asignarAtributosA(publicacion, request);
        this.repoPublicaciones.agregar(publicacion);
        response.redirect("/mascota_perdida_foto");
        return response;
    }

    public Response guardarMascotaPerdidaFoto(Request request, Response response){
        PublicacionMascotaPerdida publicacion = new PublicacionMascotaPerdida();
        asignarAtributosA(publicacion, request);
        this.repoPublicaciones.agregar(publicacion);
        response.redirect("/index");
        return response;
    }
    public Response guardarDarEnAdopcion(Request request, Response response){
        PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion();
        asignarAtributosA(publicacion, request);
        this.repoPublicaciones.agregar(publicacion);
        response.redirect("/index");
        return response;
    }

    public Response guardarIntencionAdopcion(Request request, Response response){
        PublicacionBusquedaAdopcion publicacion = new PublicacionBusquedaAdopcion();
        asignarAtributosA(publicacion, request);
        this.repoPublicaciones.agregar(publicacion);
        response.redirect("/index");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Publicacion publicacion = this.repoPublicaciones.buscar(new Integer(request.params("id")));
        this.repoPublicaciones.eliminar(publicacion);
        return response;
    }

}