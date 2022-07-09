package test;

import db.EntityManagerHelper;
import domain.entities.usuario.Persona;
import domain.entities.usuario.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class BusquedaDBTest {

    /*@Test
    public void recuperarAlUsuario() {
        Usuario eze = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombreUsuario = 'est'").getSingleResult();
        Assert.assertEquals("est", eze.getNombreUsuario());
    }

    @Test
    public void probarLogin() {
        Persona p = (Persona) EntityManagerHelper.createQuery("from Persona where usuario.nombreUsuario = 'nico' and usuario.contrasenia = 'nico123'")
                .getSingleResult();
        Assert.assertEquals("Nicolas",p.getNombre());
        Assert.assertEquals("nico",p.getUsuario().getNombreUsuario());
        Assert.assertEquals("nico123",p.getUsuario().getContrasenia());
    }*/
}
