package domain.entities.Publicaciones.MascotaPerdida;

import domain.persistencia.factories.FactoryRepositorioMascotas;
import domain.persistencia.repositorio.RepositorioDeMascotas;

public class GestorMascotaPerdida {

    private final RepositorioDeMascotas repoMascotas;

    public GestorMascotaPerdida(){
        this.repoMascotas = FactoryRepositorioMascotas.get();
    }

    public void procesarMascotaPerdida(MascotaPerdida mascotaPerdida){
        if (mascotaPerdida.getTieneChapita()){
            repoMascotas.buscarPorQR(mascotaPerdida.getChapita());
            mascotaPerdida.notificarDueño();
        }else{
            repoMascotas.generarPublicacion(mascotaPerdida);
        }
    }

}
