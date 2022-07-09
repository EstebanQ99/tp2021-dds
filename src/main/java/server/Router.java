package server;

import domain.controllers.*;
import domain.middleware.AuthMiddleware;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){

        //Login
        LoginController loginController = new LoginController();
        AuthMiddleware authMiddleware = new AuthMiddleware();

        Spark.get("/login", loginController::login, Router.engine);
        Spark.post("/login", loginController::loginPost);
        Spark.get("/logout", loginController::logout);

        Spark.before("/mascotas", authMiddleware::verificarSesion);
        Spark.before("/mascota", authMiddleware::verificarSesion);
        Spark.before("/usuarios", authMiddleware::verificarSesion);
        Spark.before("/usuario", authMiddleware::verificarSesion);
        Spark.before("/organizaciones", authMiddleware::verificarSesion);

        //Mascota
        MascotasController mascotasController = new MascotasController();

        Spark.get("/mascotas", mascotasController::mostrarMascotas, Router.engine);
        Spark.get("/mascota/:id", mascotasController::mostrarMascota, Router.engine);
        Spark.get("/mascota", mascotasController::crear, Router.engine);
        Spark.get("/encontrar_mascota_con_placa", mascotasController::encontrarMascotaConPlaca, Router.engine);
        Spark.get("/comunicar_con_duenio", mascotasController::comunicarConDuenio, Router.engine);
        Spark.get("/gracias", mascotasController::gracias,Router.engine);
        Spark.get("/adoptar_mascota", mascotasController::adoptarMascota, Router.engine);
        Spark.post("/mascota/:id", mascotasController::modificar);
        Spark.post("/mascota", mascotasController::guardar);
        Spark.delete("/mascota/:id", mascotasController::eliminar);

        //Persona - Usuario
        UsuariosController usuariosController = new UsuariosController();

        Spark.get("/usuarios", usuariosController::mostrarUsuarios, Router.engine);
        Spark.get("/usuario/:id", usuariosController::mostrarUsuario, Router.engine);
        Spark.post("/usuario/:id", usuariosController::modificar);
        Spark.delete("/usuario/:id", usuariosController::eliminar);
        Spark.get("/usuario", usuariosController::crearPersona, Router.engine);
        Spark.post("/usuario", usuariosController::guardarPersona);
        Spark.get("/registro_usuario", usuariosController::registroUsuario, Router.engine);
        Spark.post("/registro_usuario", usuariosController::guardarUsuario);
        Spark.get("/registro_organizacion", usuariosController::registroOrganizacion, Router.engine);
        Spark.post("/registro_organizacion", usuariosController::guardarOrganizacion);

        //Organizacion
        OrganizacionController organizacionController = new OrganizacionController();

        Spark.get("/organizaciones", organizacionController::mostrarOrganizaciones, Router.engine);
        Spark.get("/file_upload", organizacionController::subirArchivo, Router.engine);
        Spark.post("/file_upload", organizacionController::guardarArchivo);

        //Publicaciones
        PublicacionesController publicacionesController = new PublicacionesController();

        Spark.get("/", publicacionesController::mostrarPublicaciones, Router.engine);
        Spark.get("/index", publicacionesController::mostrarPublicaciones, Router.engine);
        Spark.get("/recomendados", publicacionesController::mostrarRecomendaciones, Router.engine);
        Spark.get("/mascota_perdida", publicacionesController::mascotaPerdida, Router.engine);
        Spark.get("/mascota_perdida_foto", publicacionesController::mascotaPerdidaFoto, Router.engine);
        Spark.get("/dar_en_adopcion", publicacionesController::darEnAdopcion, Router.engine);
        Spark.get("/intencion_adopcion", publicacionesController::intencionAdopcion, Router.engine);
        Spark.post("/mascota_perdida", publicacionesController::guardarMascotaPerdida);
        Spark.post("/mascota_perdida_foto", publicacionesController::guardarMascotaPerdidaFoto);
        Spark.post("/dar_en_adopcion", publicacionesController::guardarDarEnAdopcion);
        Spark.post("/intencion_adopcion", publicacionesController::guardarIntencionAdopcion);
        Spark.delete("/mascota_perdida/:id", publicacionesController::eliminar);
        Spark.delete("/dar_en_adopcion/:id", publicacionesController::eliminar);
        Spark.delete("/intencion_adopcion/:id", publicacionesController::eliminar);

        //API recomendaciones
        RecomendadorController recomendadorController = new RecomendadorController();

        Spark.get("/generar_recomendaciones",recomendadorController::calcularRecomendaciones);
        //Spark.get("/api/recomendaciones",recomendadorController::mostrarRecomendaciones);

        //Header
        //HeaderController headerController = new HeaderController();

        //Spark.get("/index", headerController::index, Router.engine);
        //Spark.get("/usuarios", headerController::usuarios, Router.engine);
        //Spark.get("/organizaciones", headerController::organizaciones, Router.engine);
        //Spark.get("/mascotas", headerController::mascotas, Router.engine);
        //Spark.get("/logout", headerController::logout, Router.engine);
        //Spark.get("/intencion_adopcion", headerController::intencionAdopcion, Router.engine);
        //Spark.get("/mascota_perdida", headerController::mascotaPerdida, Router.engine);
        //Spark.get("/dar_en_adopcion", headerController::darEnAdopcion, Router.engine);
        //Spark.post("/intencion_adopcion", headerController::crearPublicacionIntencionDeAdopcion);
        //Spark.post("/mascota_perdida", headerController::completarFormularioParaMascotaPerdida);
        //Spark.post("/dar_en_adopcion", headerController::completarFormularioParaDarEnAdopcion);

    }
}