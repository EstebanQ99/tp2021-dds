package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.Organizacion.Organizacion;
import domain.entities.usuario.Persona;
import spark.Request;

import java.util.List;
import java.util.Map;

public abstract class AuthControllers {

    void asignarUsuarioSiEstaLogueado(Request request, Map<String, Object> parametros){
        if(!request.session().isNew() && request.session().attribute("id") != null){

            List persona = EntityManagerHelper.createQuery("from Persona " +
                            "where usuario.id ="+request.session().attribute("id"))
                    .getResultList();

            List admin = EntityManagerHelper.createQuery("from Organizacion " +
                            "where usuario.id ="+request.session().attribute("id"))
                    .getResultList();
            if(!persona.isEmpty()){
                parametros.put("persona", persona.get(0));
            }
            else if(!admin.isEmpty()){
                parametros.put("organizacion", admin.get(0));
            }
//            else {
//                parametros.put("usuario", usuario);
//            }

        }
    }
}
