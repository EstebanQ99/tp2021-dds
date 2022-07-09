package domain.entities.Publicaciones;

import domain.entities.EntidadPersistente;
import domain.entities.Mascota.CaractMascota;
import domain.entities.Publicaciones.Preguntas.PreguntaAdopcionSistema;
import domain.entities.Publicaciones.Preguntas.PreguntaConRespuesta;
import domain.entities.usuario.Calificable;
import domain.entities.usuario.CaracteristicaUsuario;
import domain.entities.usuario.Comodidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matchPublicaciones")
public class MatchPublicaciones extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name= "pregAdopSist_id", referencedColumnName = "id")
    private PreguntaAdopcionSistema pregAdopSist;

    @ManyToOne
    @JoinColumn(name= "pregConResp_id", referencedColumnName = "id")
    private PreguntaConRespuesta pregOrganizacion;

    @ManyToOne
    @JoinColumn(name= "comodidad_id", referencedColumnName = "id")
    private Comodidad comodidad;

    @ManyToOne
    @JoinColumn(name= "caractUsuario_id", referencedColumnName = "id")
    private CaracteristicaUsuario caractUsuario;

    @ManyToOne
    @JoinColumn(name= "caractMascota_id", referencedColumnName = "id")
    private CaractMascota preferencia;

    public Boolean tengoLaMismaPregAdop(List<PreguntaAdopcionSistema> preg){return preg.contains(pregAdopSist);}

    public Boolean tengoLaMismaPregSist(List<PreguntaConRespuesta> preg){return preg.contains(pregOrganizacion);}

    public Boolean tengoElMismoCalificable(List<Calificable> calificables){
        return calificables.contains(comodidad) || calificables.contains(caractUsuario);
    }

    public Boolean tengoLaMismaPreferencia(List<CaractMascota> preferencias){return preferencias.contains(preferencia);}

    public PreguntaAdopcionSistema getPregAdopSist() {return pregAdopSist;}

    public void setPregAdopSist(PreguntaAdopcionSistema pregAdopSist) {this.pregAdopSist = pregAdopSist;}

    public PreguntaConRespuesta getPregOrganizacion() {return pregOrganizacion;}

    public void setPregOrganizacion(PreguntaConRespuesta pregOrganizacion) {this.pregOrganizacion = pregOrganizacion;}

    public Calificable getCaractUsuario() {return this.caractUsuario;}

    public void setCaractUsuario(CaracteristicaUsuario caractUsuario) {this.caractUsuario = caractUsuario;}

    public CaractMascota getPreferencia() {return preferencia;}

    public void setPreferencia(CaractMascota preferencia) {this.preferencia = preferencia;}

    public Comodidad getComodidad() {
        return comodidad;
    }

    public void setComodidad(Comodidad comodidad) {
        this.comodidad = comodidad;
    }


}
