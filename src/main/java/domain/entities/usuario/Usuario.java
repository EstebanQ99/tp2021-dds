package domain.entities.usuario;

import domain.entities.EntidadPersistente;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadPersistente{

    @Column
    private String nombreUsuario;

    @Column
    private String contrasenia;

    @Transient
    private ValidadorDeContrasenias validadorPass;

    public String getNombreUsuario() {return nombreUsuario;}

    public String getContrasenia() {return contrasenia;}

    public void setNombreUsuario(String usuario) {this.nombreUsuario = usuario;}

    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}

    public ValidadorDeContrasenias getValidadorPass() {
        return validadorPass;
    }

    public void setValidadorPass(ValidadorDeContrasenias validadorPass) {
        this.validadorPass = validadorPass;
    }

    public void cambiarContrasenia() throws IOException {
       validadorPass.cambiarContraseniaExistente(this,false);
    }
}
