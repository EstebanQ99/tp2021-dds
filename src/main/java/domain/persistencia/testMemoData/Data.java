package domain.persistencia.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.Mascota.Mascota;
import domain.entities.Organizacion.Organizacion;
import domain.entities.Publicaciones.Publicacion;
import domain.entities.usuario.Persona;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<EntidadPersistente> getData(Class type){
        List<EntidadPersistente> entidades = new ArrayList<>();
        if(type.getName().equals(Organizacion.class.getName())){
            entidades = DataOrganizacion.getList();
        }
        else{
            if(type.getName().equals(Persona.class.getName())){
                entidades = DataPersona.getList();
            }
            if(type.getName().equals(Mascota.class.getName())){
                entidades = DataMascota.getList();
            }
            if(type.getName().equals(Publicacion.class.getName())){
                entidades = DataPublicaciones.getList();
            }
        }

        return entidades;
    }
}
