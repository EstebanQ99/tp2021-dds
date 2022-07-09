package domain.entities.usuario.MediosNotificacion;

import domain.entities.usuario.Contacto;

public interface MedioNotificacion {

    public void enviarNotificacion(Contacto contacto, String mensaje);
}

class Whatsapp implements MedioNotificacion {

    public void enviarNotificacion(Contacto contacto, String mensaje){

    }

}

class Sms implements MedioNotificacion {

    public void enviarNotificacion(Contacto contacto, String mensaje){

    }
}