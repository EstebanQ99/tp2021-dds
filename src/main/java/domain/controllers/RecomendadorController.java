package domain.controllers;

import com.google.gson.Gson;
import db.EntityManagerHelper;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.entities.Publicaciones.Adopciones.RecomendadorAdopcion;
import domain.entities.Publicaciones.PublicacionRecomendada;
import domain.entities.usuario.Persona;
import spark.Request;
import spark.Response;

import java.util.List;

public class RecomendadorController {

    private final RecomendadorAdopcion recoAdopcion;

    public RecomendadorController(){
        this.recoAdopcion = new RecomendadorAdopcion();
    }

    //POST (hace corrida de recomendaciones)
    public Response calcularRecomendaciones(Request request, Response response){

        List<PublicacionRecomendada> listaRecomendaciones = recoAdopcion.obtenerTodasLasRecomendaciones();
        if(!listaRecomendaciones.isEmpty()){
            EntityManagerHelper.beginTransaction();

            listaRecomendaciones.forEach(pub -> EntityManagerHelper.getEntityManager().persist(pub));

            EntityManagerHelper.commit();
        }
        response.redirect("/index");
        return response;
    }
/*
    //GET (muestra las recomendaciones en formato json)
    public String mostrarRecomendaciones(Request request, Response response){
        Gson gson = new Gson();
        //obtener corrida de recomendaciones
        //mostrar json (ACA YO LE MANDE UNA RECOMENDACION RANDOM PARA QUE NO ROMPA)
        return gson.toJson(new PublicacionRecomendada(new Persona(),new PublicacionMascotaEnAdopcion()));
    }
*/
}
