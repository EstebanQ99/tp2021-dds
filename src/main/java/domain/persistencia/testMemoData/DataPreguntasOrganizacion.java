package domain.persistencia.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.PreguntaOrganizacion;
import domain.entities.Publicaciones.Preguntas.PreguntaConRespuesta;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataPreguntasOrganizacion {

    private static List<PreguntaConRespuesta> preguntasOrganizacion = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(preguntasOrganizacion.size() == 0) {

            //1
            PreguntaOrganizacion preguntaOrganizacionGatoAngel = new PreguntaOrganizacion();
            preguntaOrganizacionGatoAngel.setPregunta("es amigable?");
            PreguntaConRespuesta preguntaConRespuestaGatoAngel = new PreguntaConRespuesta();
            preguntaConRespuestaGatoAngel.setPregunta(preguntaOrganizacionGatoAngel);
            preguntaConRespuestaGatoAngel.setRespuesta("un poco");

            //2
            PreguntaOrganizacion preguntaOrganizacionPerroMiguel = new PreguntaOrganizacion();
            preguntaOrganizacionPerroMiguel.setPregunta("es macho?");
            PreguntaConRespuesta preguntaConRespuestaPerroMiguel = new PreguntaConRespuesta();
            preguntaConRespuestaPerroMiguel.setPregunta(preguntaOrganizacionPerroMiguel);
            preguntaConRespuestaPerroMiguel.setRespuesta("si");

            //3
            PreguntaOrganizacion preguntaOrganizacionGatoEnrique = new PreguntaOrganizacion();
            preguntaOrganizacionGatoEnrique.setPregunta("tiene las vacunas al dia?");
            PreguntaConRespuesta preguntaConRespuestaGatoEnrique = new PreguntaConRespuesta();
            preguntaConRespuestaGatoEnrique.setPregunta(preguntaOrganizacionGatoEnrique);
            preguntaConRespuestaGatoEnrique.setRespuesta("si");

            //Set ids
            preguntaConRespuestaGatoAngel.setId(1);
            preguntaConRespuestaPerroMiguel.setId(2);
            preguntaConRespuestaGatoEnrique.setId(3);

            addAll(preguntaConRespuestaGatoAngel,preguntaConRespuestaPerroMiguel,preguntaConRespuestaGatoEnrique);
        }

        return (List<EntidadPersistente>)(List<?>) preguntasOrganizacion;
    }

    private static void addAll(PreguntaConRespuesta ... preguntasOrganizacion){
        Collections.addAll(DataPreguntasOrganizacion.preguntasOrganizacion, preguntasOrganizacion);
    }
}
