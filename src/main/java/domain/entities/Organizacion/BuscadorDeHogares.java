package domain.entities.Organizacion;

import domain.entities.Organizacion.Hogares.Hogar;
import domain.entities.Organizacion.Hogares.ListadoDeHogares;
import domain.entities.Organizacion.Hogares.HogaresAPI;

import java.io.IOException;
import java.util.List;

public class BuscadorDeHogares {
    public List<Hogar> buscarHogares() throws IOException {
        HogaresAPI hogaresAPI = HogaresAPI.getInstancia();

        ListadoDeHogares listadoDeHogares = hogaresAPI.listadoDeHogares();

        return listadoDeHogares.hogares;
   }
//   public List<Hogar> buscarHogarParaMascota(MascotaPerdida mascotaPerdida){}
}