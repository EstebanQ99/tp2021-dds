package domain.controllers;

import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Persona;
import domain.persistencia.repositorio.Repositorio;
import domain.persistencia.repositorio.RepositorioDeMascotas;
import domain.persistencia.repositorio.RepositorioPersona;
import domain.persistencia.factories.FactoryRepositorio;
import domain.persistencia.factories.FactoryRepositorioMascotas;
import domain.persistencia.factories.FactoryRepositorioPersona;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotasController extends AuthControllers{

    private final RepositorioPersona repoPersona;
    private final Repositorio<Organizacion> repoOrganizacion;
    private final RepositorioDeMascotas repoMascota;

    public MascotasController(){
        this.repoPersona = FactoryRepositorioPersona.get();
        this.repoMascota = FactoryRepositorioMascotas.get();
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

    public ModelAndView mostrarMascotas(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        List<Mascota> mascotas = this.repoMascota.buscarMascotasUsuario(request.session().attribute("id"));
        parametros.put("mascotas", mascotas);
        return new ModelAndView(parametros, "mascotas.hbs");
    }

    public ModelAndView mostrarMascota(Request request, Response response){
        Mascota mascota= this.repoMascota.buscar(new Integer(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("mascota", mascota);
        return new ModelAndView(parametros, "mascota.hbs");
    }

    public Response modificar(Request request, Response response){
        Mascota mascota = this.repoMascota.buscar(new Integer(request.params("id")));
        asignarAtributosA(mascota, request);
        this.repoMascota.modificar(mascota);
        response.redirect("/mascotas");
        return response;
    }

    private void asignarAtributosA(Mascota mascota, Request request){
        if(request.queryParams("nombre") != null){
            mascota.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("dueño") != null){
            Persona nuevoDuenio = repoPersona.buscar(new Integer(request.queryParams("dueño")));
            mascota.setPersona(nuevoDuenio);
        }
    }

    public ModelAndView crear(Request request,Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "mascota.hbs");
    }

    public Response guardar(Request request, Response response){
        Mascota mascota = new Mascota();
        asignarAtributosA(mascota, request);
        this.repoMascota.agregar(mascota);
        response.redirect("/mascotas");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Mascota mascota = this.repoMascota.buscar(new Integer(request.params("id")));
        this.repoMascota.eliminar(mascota);
        return response;
    }

    public ModelAndView encontrarMascotaConPlaca(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "encontrar_mascota_con_placa.hbs");
    }

    public ModelAndView comunicarConDuenio(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "comunicar_con_duenio.hbs");
    }

    public ModelAndView gracias(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "gracias.hbs");
    }

    public ModelAndView adoptarMascota(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "adoptar_mascota.hbs");
    }

}
