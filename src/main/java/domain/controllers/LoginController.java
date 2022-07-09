package domain.controllers;

import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.factories.FactoryRepositorio;
import domain.persistencia.factories.FactoryRepositorioOrganizacion;
import domain.persistencia.repositorio.Repositorio;
import domain.persistencia.factories.FactoryRepositorioPersona;
import domain.persistencia.repositorio.RepositorioOrganizacion;
import domain.persistencia.repositorio.RepositorioPersona;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    public ModelAndView login(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login.hbs");
    }

    public Response loginPost(Request request, Response response) {
        try {
            RepositorioPersona repoPersona = FactoryRepositorioPersona.get();
            RepositorioOrganizacion repoOrganizacion = FactoryRepositorioOrganizacion.get();

            String nombreUsuario = request.queryParams("usuario");
            String contrasenia = request.queryParams("contrasenia");

            if (repoPersona.existe(nombreUsuario, contrasenia)) {
                Persona persona = repoPersona.buscarUsuario(nombreUsuario, contrasenia);

                request.session(true);
                request.session().attribute("id", persona.getUsuario().getId());

                response.redirect("/index");
            }
            else if (repoOrganizacion.existe(nombreUsuario, contrasenia)){
                Organizacion organizacion = repoOrganizacion.buscarUsuario(nombreUsuario, contrasenia);

                request.session(true);
                request.session().attribute("id", organizacion.getUsuario().getId());

                response.redirect("/index");
            }

            else {
                response.redirect("/login");
            }
        } catch (Exception e) {
            //Funcionalidad disponible solo con persistencia en Base de Datos
            response.redirect("/index");
        }
        return response;
    }

    public Response logout(Request request, Response response){
        request.session().invalidate();
        response.redirect("/index");
        return response;
    }

}