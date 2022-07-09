package domain.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HeaderController extends AuthControllers{

    public ModelAndView index(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "index.hbs");
    }

    public ModelAndView usuarios(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView organizaciones(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "organizaciones.hbs");
    }

    public ModelAndView mascotas(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "mascotas.hbs");
    }

    public ModelAndView logout(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "logout.hbs");
    }

    public ModelAndView intencionAdopcion(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "intencion_adopcion.hbs");
    }

    public Response crearPublicacionIntencionDeAdopcion(Request request, Response response){
        response.redirect("/index");
        return response;
    }

    public ModelAndView mascotaPerdida(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "mascota_perdida.hbs");
    }

    public Response completarFormularioParaMascotaPerdida(Request request, Response response){
        response.redirect("/index");
        return response;
    }

    public ModelAndView darEnAdopcion(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "dar_en_adopcion.hbs");
    }

    public Response completarFormularioParaDarEnAdopcion(Request request, Response response){
        response.redirect("/index");
        return response;
    }
}
