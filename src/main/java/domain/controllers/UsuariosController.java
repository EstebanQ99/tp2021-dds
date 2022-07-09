package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Contacto;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.repositorio.Repositorio;
import domain.persistencia.factories.FactoryRepositorio;
import domain.persistencia.factories.FactoryRepositorioPersona;
import domain.persistencia.repositorio.RepositorioPersona;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuariosController extends AuthControllers {
    private RepositorioPersona repoPersona;
    private Repositorio<Organizacion> repoOrganizacion;

    public UsuariosController(){
        this.repoPersona = FactoryRepositorioPersona.get();
        this.repoOrganizacion = FactoryRepositorio.get(Organizacion.class);
    }

//    private void asignarUsuarioSiEstaLogueado(Request request, Map<String, Object> parametros){
//        if(!request.session().isNew() && request.session().attribute("id") != null){
//
//            Persona persona = (Persona) EntityManagerHelper.createQuery("from Persona " +
//                            "where usuario.id ="+request.session().attribute("id"))
//                    .getSingleResult();
//
//            Organizacion admin = (Organizacion) EntityManagerHelper.createQuery("from Organizacion " +
//                            "where usuario.id ="+request.session().attribute("id"))
//                    .getSingleResult();
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

    public ModelAndView mostrarUsuarios(Request request, Response response) { //Solo admin
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        List<Persona> personas = this.repoPersona.buscarTodos();
        List<Organizacion> admins = this.repoOrganizacion.buscarTodos();
        parametros.put("personas", personas);
        parametros.put("admins", admins);

        return new ModelAndView(parametros, "usuarios.hbs");
    }

    public ModelAndView mostrarUsuario(Request request, Response response){ //Solo persona
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        Persona persona = this.repoPersona.buscar(new Integer(request.params("id")));
        parametros.put("persona", persona);

        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response){
        Persona persona = this.repoPersona.buscar(new Integer(request.params("id")));
        asignarAtributosA(persona, request);
        this.repoPersona.modificar(persona);
        response.redirect("/index");
        return response;
    }

    private void asignarAtributosA(Persona persona, Request request){

        if(request.queryParams("nombreUsuario") != null){
            persona.getUsuario().setNombreUsuario(request.queryParams("nombreUsuario"));
        }

        if(request.queryParams("contrasenia") != null){
            persona.getUsuario().setContrasenia(request.queryParams("contrasenia"));
        }

        if(request.queryParams("nombre") != null){
            persona.setNombre(request.queryParams("nombre"));
        }
        if(request.queryParams("apellido") != null){
            persona.setApellido(request.queryParams("apellido"));
        }

        if(request.queryParams("direccion") != null){
            persona.setDireccion(request.queryParams("direccion"));
        }

        if(request.queryParams("fechaNac") != null && !request.queryParams("fechaNac").isEmpty()){
            LocalDate fechaNac = LocalDate.parse(request.queryParams("fechaNac"));
            persona.setFechaNac(fechaNac);
        }

        if(request.queryParams("contacto") != null){
            Repositorio<Contacto> repoContacto = FactoryRepositorio.get(Contacto.class);
            Contacto unContacto = repoContacto.buscar(new Integer(request.queryParams("contacto")));
            if(request.queryParams("telefono") != null){
                int telefono = new Integer(request.queryParams("telefono"));
                unContacto.setTelefono(telefono);
            }
            if(request.queryParams("email") != null){
                unContacto.setEmail(request.queryParams("email"));
            }
        }
    }

    private void asignarAtributosA(Organizacion organizacion, Request request){
        if(request.queryParams("usuario") != null){
            organizacion.getUsuario().setNombreUsuario(request.queryParams("usuario"));
        }

        if(request.queryParams("contrasenia") != null){
            organizacion.getUsuario().setContrasenia(request.queryParams("contrasenia"));
        }
    }


    public Response eliminar(Request request, Response response){
        Persona persona = this.repoPersona.buscar(new Integer(request.params("id")));
        Organizacion admin = this.repoOrganizacion.buscar(new Integer(request.params("id")));
        if( persona != null){
            this.repoPersona.eliminar(persona);
        }
        else if( admin != null){
            this.repoOrganizacion.eliminar(admin);
        }

        return response;
    }

    public ModelAndView registroUsuario(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"registro_usuario.hbs");
    }

    public Response guardarUsuario(Request request, Response response){
        Persona persona = new Persona();
        asignarAtributosA(persona, request);
        this.repoPersona.agregar(persona);
        response.redirect("/usuario");
        return response;
    }

    public ModelAndView crearPersona(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response guardarPersona(Request request, Response response){
        Persona persona = this.repoPersona.buscar(new Integer(request.params("id")));
        asignarAtributosA(persona, request);
        this.repoPersona.modificar(persona);
        response.redirect("/login");
        return response;
    }

    public ModelAndView registroOrganizacion(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"registro_organizacion.hbs");
    }

    public Response guardarOrganizacion(Request request, Response response){
        Organizacion organizacion = new Organizacion();
        asignarAtributosA(organizacion, request);
        this.repoOrganizacion.agregar(organizacion);
        response.redirect("/login");
        return response;
    }

}