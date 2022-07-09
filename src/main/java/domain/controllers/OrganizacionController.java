package domain.controllers;

import com.google.gson.Gson;
import domain.entities.Organizacion.Organizacion;
import domain.entities.Publicaciones.ListaMatchPublicaciones;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import domain.persistencia.repositorio.Repositorio;
import domain.persistencia.repositorio.RepositorioPersona;
import domain.persistencia.factories.FactoryRepositorio;
import domain.persistencia.factories.FactoryRepositorioPersona;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import java.io.*;
import java.nio.file.*;


public class OrganizacionController extends AuthControllers{

    private final Repositorio<Persona> repoPersona;
    private final Repositorio<Organizacion> repoOrganizacion;
    private final RepositorioPersona repoUsuario;

    public OrganizacionController() {
        this.repoPersona = FactoryRepositorio.get(Persona.class);
        this.repoOrganizacion = FactoryRepositorio.get(Organizacion.class);
        this.repoUsuario = FactoryRepositorioPersona.get();
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

    public ModelAndView mostrarOrganizaciones(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        List<Organizacion> organizaciones = this.repoOrganizacion.buscarTodos();
        parametros.put("organizaciones", organizaciones);
        return new ModelAndView(parametros, "organizaciones.hbs");
    }

    public ModelAndView subirArchivo(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        asignarUsuarioSiEstaLogueado(request, parametros);
        return new ModelAndView(parametros, "file_upload.hbs");
    }

    //Esto no anda
    public Response guardarArchivo(Request request, Response response) throws IOException {
        File uploadDir = new File("src/main/resources/public/fileuploads");
        uploadDir.mkdir();
        //staticFiles.location("/public");
        Path tempFile = Files.createTempFile(uploadDir.toPath(), "rules", ".txt");
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

        try (InputStream input = request.raw().getPart("uploaded_file").getInputStream()) {
            Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
            String json = new String(Files.readAllBytes(Paths.get(tempFile.toString())));
            ListaMatchPublicaciones listaMatchPublicaciones = new Gson().fromJson(json, ListaMatchPublicaciones.class);
            System.out.println(listaMatchPublicaciones.getMatch());
        } catch (ServletException e) {
            e.printStackTrace();
        }




        response.redirect("/index");
        return response;
    }

//    public ModelAndView mostrarOrganizacion(Request request, Response response){
//        Organizacion organizacion = this.repoOrganizacion.buscar(new Integer(request.params("id")));
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("organizacion", organizacion);
//        return new ModelAndView(parametros, "organizacion.hbs");
//    }
//
//    public Response modificar(Request request, Response response){
//        Organizacion organizacion = this.repoOrganizacion.buscar(new Integer(request.params("id")));
//        asignarAtributosA(organizacion, request);
//        this.repoOrganizacion.modificar(organizacion);
//        response.redirect("/organizaciones");
//        return response;
//    }
//
//    private void asignarAtributosA(Organizacion organizacion, Request request) {
//        if (request.queryParams("nombre") != null) {
//            organizacion.setNombre(request.queryParams("nombre"));
//        }
//    }
//
//    public ModelAndView crear(Request request,Response response){
//        Map<String, Object> parametros = new HashMap<>();
//        return new ModelAndView(parametros, "organizacion.hbs");
//    }
//
//    public Response guardar(Request request, Response response){
//        Organizacion organizacion = new Organizacion();
//        asignarAtributosA(organizacion, request);
//        this.repoOrganizacion.agregar(organizacion);
//        response.redirect("/organizaciones");
//        return response;
//    }
}
