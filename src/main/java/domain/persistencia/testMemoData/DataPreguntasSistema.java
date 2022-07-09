package domain.persistencia.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.Publicaciones.Preguntas.PreguntaAdopcionSistema;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataPreguntasSistema {
    private static List<PreguntaAdopcionSistema> preguntasSistema = new ArrayList<>();

    public static List<EntidadPersistente> getList(){
        if(preguntasSistema.size() == 0) {

            //1
            PreguntaSistema preguntaSistemaGatoAngel = new PreguntaSistema();
            preguntaSistemaGatoAngel.setPregunta("que edad tiene?");

            PreguntaAdopcionSistema preguntaAdopcionSistemaGatoAngel = new PreguntaAdopcionSistema();
            preguntaAdopcionSistemaGatoAngel.setPregunta(preguntaSistemaGatoAngel);

            //2
            PreguntaSistema preguntaSistemaPerroMiguel = new PreguntaSistema();
            preguntaSistemaPerroMiguel.setPregunta("cual es su color principal?");

            PreguntaAdopcionSistema preguntaAdopcionSistemaPerroMiguel = new PreguntaAdopcionSistema();
            preguntaAdopcionSistemaPerroMiguel.setPregunta(preguntaSistemaPerroMiguel);

            //3
            PreguntaSistema preguntaSistemaGatoEnrique = new PreguntaSistema();
            preguntaSistemaGatoEnrique.setPregunta("cual es su tamaño?");

            PreguntaAdopcionSistema preguntaAdopcionSistemaGatoEnrique = new PreguntaAdopcionSistema();
            preguntaAdopcionSistemaGatoEnrique.setPregunta(preguntaSistemaGatoEnrique);

            //Set ids
            preguntaAdopcionSistemaGatoAngel.setId(1);
            preguntaAdopcionSistemaPerroMiguel.setId(2);
            preguntaAdopcionSistemaGatoEnrique.setId(3);

            addAll(preguntaAdopcionSistemaGatoAngel,preguntaAdopcionSistemaPerroMiguel,preguntaAdopcionSistemaGatoEnrique);
        }

        return (List<EntidadPersistente>)(List<?>) preguntasSistema;
    }

    private static void addAll(PreguntaAdopcionSistema ... preguntasSistema){
        Collections.addAll(DataPreguntasSistema.preguntasSistema, preguntasSistema);
    }
}
