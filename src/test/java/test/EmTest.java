package test;

import db.EntityManagerHelper;
import domain.entities.Mascota.*;
import domain.entities.Organizacion.*;
import domain.entities.Publicaciones.*;
import domain.entities.Publicaciones.Adopciones.PublicacionBusquedaAdopcion;
import domain.entities.Publicaciones.Adopciones.PublicacionMascotaEnAdopcion;
import domain.entities.Publicaciones.MascotaPerdida.MascotaPerdida;
import domain.entities.Publicaciones.MascotaPerdida.PublicacionMascotaPerdida;
import domain.entities.Publicaciones.Preguntas.PreguntaAdopcionSistema;
import domain.entities.Publicaciones.Preguntas.PreguntaConRespuesta;
import domain.entities.Publicaciones.Preguntas.PreguntaSistema;
import domain.entities.usuario.*;
import org.junit.Test;
import java.time.LocalDate;

public class EmTest{

    /*@Test
    public void persistirUsuario(){

        //PERSONA Y CONTACTO
        Usuario u_federico = new Usuario();
        u_federico.setNombreUsuario("fede");
        u_federico.setContrasenia("fede123");
        Persona federico = new Persona();
        federico.setUsuario(u_federico);
        Contacto c_federico = new Contacto();
        c_federico.setEmail("fcaminoa@email.com");
        c_federico.setTelefono(12345678);
        federico.setNombre("Federico");
        federico.setApellido("Caminoa");
        federico.setDireccion("Av Corrientes 1234");
        federico.setFechaNac(LocalDate.parse("1998-11-11"));
        federico.setContactos(c_federico);

        Usuario u_esteban = new Usuario();
        u_esteban.setNombreUsuario("est");
        u_esteban.setContrasenia("est123");
        Persona esteban = new Persona();
        esteban.setUsuario(u_esteban);
        Contacto c_esteban = new Contacto();
        c_esteban.setEmail("equintana@email.com");
        c_esteban.setTelefono(12345678);
        esteban.setNombre("Esteban");
        esteban.setApellido("Quintana");
        esteban.setDireccion("Av Rivadavia 12340");
        esteban.setFechaNac(LocalDate.parse("1998-10-10"));
        esteban.setContactos(c_esteban);

        Usuario u_nicolas = new Usuario();
        u_nicolas.setNombreUsuario("nico");
        u_nicolas.setContrasenia("nico123");
        Persona nicolas = new Persona();
        nicolas.setUsuario(u_nicolas);
        Contacto c_nicolas = new Contacto();
        c_nicolas.setEmail("nbertoni@email.com");
        c_nicolas.setTelefono(12345678);
        nicolas.setNombre("Nicolas");
        nicolas.setApellido("Bertoni");
        nicolas.setDireccion("Av Belgrano 4321");
        nicolas.setFechaNac(LocalDate.parse("1998-09-09"));
        nicolas.setContactos(c_nicolas);

        // PERRO Y GATO
        Mascota perroFede = new Mascota();
        perroFede.setNombre("PerroFede");
        perroFede.setPersona(federico);
        perroFede.setTipo("Siberiano");
        perroFede.setEdad(4);

        Mascota gatoFede = new Mascota();
        gatoFede.setNombre("GatoFede");
        gatoFede.setPersona(federico);
        gatoFede.setTipo("Persa");
        gatoFede.setEdad(5);

        Mascota perroNico = new Mascota();
        perroNico.setNombre("PerroNico");
        perroNico.setPersona(nicolas);
        perroNico.setTipo("Bull Dog");
        perroNico.setEdad(2);

        Mascota gatoNico = new Mascota();
        gatoNico.setNombre("GatoNico");
        gatoNico.setPersona(nicolas);
        gatoNico.setTipo("Esfinge");
        gatoNico.setEdad(7);

        Mascota perroEst = new Mascota();
        perroEst.setNombre("PerroEst");
        perroEst.setPersona(esteban);
        perroEst.setTipo("Golden");
        perroEst.setEdad(4);

        Mascota gatoEst = new Mascota();
        gatoEst.setNombre("GatoEst");
        gatoEst.setPersona(esteban);
        gatoEst.setTipo("Somali");
        gatoEst.setEdad(6);

        //PREGUNTAS
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

        //1
        PreguntaSistema preguntaSistemaGatoAngel = new PreguntaSistema();
        preguntaSistemaGatoAngel.setPregunta("que edad tiene?");

        PreguntaAdopcionSistema preguntaAdopcionSistemaGatoAngel = new PreguntaAdopcionSistema();
        preguntaAdopcionSistemaGatoAngel.setPregunta(preguntaSistemaGatoAngel);
        preguntaAdopcionSistemaGatoAngel.setRespuesta("7");

        //2
        PreguntaSistema preguntaSistemaPerroMiguel = new PreguntaSistema();
        preguntaSistemaPerroMiguel.setPregunta("cual es su color principal?");

        PreguntaAdopcionSistema preguntaAdopcionSistemaPerroMiguel = new PreguntaAdopcionSistema();
        preguntaAdopcionSistemaPerroMiguel.setPregunta(preguntaSistemaPerroMiguel);
        preguntaAdopcionSistemaPerroMiguel.setRespuesta("gris");

        //3
        PreguntaSistema preguntaSistemaGatoEnrique = new PreguntaSistema();
        preguntaSistemaGatoEnrique.setPregunta("cual es su tamaño?");

        PreguntaAdopcionSistema preguntaAdopcionSistemaGatoEnrique = new PreguntaAdopcionSistema();
        preguntaAdopcionSistemaGatoEnrique.setPregunta(preguntaSistemaGatoEnrique);
        preguntaAdopcionSistemaGatoEnrique.setRespuesta("chico");

        //PUBLICACIONES

        //Publicacion Busqueda Adopcion

        //1
        Usuario u_sol = new Usuario();
        u_sol.setNombreUsuario("sol");
        u_sol.setContrasenia("sol123");
        Persona sol = new Persona();
        sol.setUsuario(u_sol);
        sol.setNombre("Sol");
        sol.setApellido("Rodriguez");
        sol.setTipoDoc("dni");
        sol.setNroDoc(11111111);

        Comodidad comodidadSol = new Comodidad();
        comodidadSol.setNombre("patio");
        comodidadSol.setValor("grande");

        Caracteristica caracteristicaSol = new Caracteristica();
        caracteristicaSol.setNombre("color principal");

        CaractMascota preferenciaSol = new CaractMascota();
        preferenciaSol.setCaracteristica(caracteristicaSol);
        preferenciaSol.setValor("gris");

        PublicacionBusquedaAdopcion publicacionBusquedaAdopcionSol = new PublicacionBusquedaAdopcion();
        publicacionBusquedaAdopcionSol.setPersona(sol);
        publicacionBusquedaAdopcionSol.getPersona().getComodidades().add(comodidadSol);
        publicacionBusquedaAdopcionSol.getPreferencias().add(preferenciaSol);

        //2
        Usuario u_lucas = new Usuario();
        u_lucas.setNombreUsuario("lucas");
        u_lucas.setContrasenia("lucas123");
        Persona lucas = new Persona();
        lucas.setUsuario(u_lucas);
        lucas.setNombre("Lucas");
        lucas.setApellido("Aguilar");
        lucas.setTipoDoc("dni");
        lucas.setNroDoc(22222222);

        Comodidad comodidadLucas = new Comodidad();
        comodidadLucas.setNombre("otras mascotas");
        comodidadLucas.setValor("si");

        Caracteristica caracteristicaLucas = new Caracteristica();
        caracteristicaLucas.setNombre("color secundario");

        CaractMascota preferenciaLucas = new CaractMascota();
        preferenciaLucas.setCaracteristica(caracteristicaLucas);
        preferenciaLucas.setValor("rubio");

        PublicacionBusquedaAdopcion publicacionBusquedaAdopcionLucas = new PublicacionBusquedaAdopcion();
        publicacionBusquedaAdopcionLucas.setPersona(lucas);
        publicacionBusquedaAdopcionLucas.getPersona().getComodidades().add(comodidadLucas);
        publicacionBusquedaAdopcionLucas.getPreferencias().add(preferenciaLucas);

        //3
        Usuario u_omar = new Usuario();
        u_omar.setNombreUsuario("omar");
        u_omar.setContrasenia("omar123");
        Persona omar = new Persona();
        omar.setUsuario(u_omar);
        omar.setNombre("Omar");
        omar.setApellido("Maro");
        omar.setTipoDoc("dni");
        omar.setNroDoc(33333333);

        Comodidad comodidadOmar = new Comodidad();
        comodidadOmar.setNombre("balcon");
        comodidadOmar.setValor("chico");

        Caracteristica caracteristicaOmar = new Caracteristica();
        caracteristicaOmar.setNombre("tamaño");
        CaractMascota preferenciaOmar = new CaractMascota();
        preferenciaOmar.setCaracteristica(caracteristicaOmar);
        preferenciaOmar.setValor("chico");

        PublicacionBusquedaAdopcion publicacionBusquedaAdopcionOmar = new PublicacionBusquedaAdopcion();
        publicacionBusquedaAdopcionOmar.setPersona(omar);
        publicacionBusquedaAdopcionOmar.getPersona().getComodidades().add(comodidadOmar);
        publicacionBusquedaAdopcionOmar.getPreferencias().add(preferenciaOmar);

        //Publicacion Dar En Adopcion

        //4
//        Mascota gatoAngel = new Mascota();
//        gatoAngel.setNombre("Angel");
//
//        PublicacionMascotaEnAdopcion publicacionMascotaEnAdopcionGatoAngel = new PublicacionMascotaEnAdopcion();
//        publicacionMascotaEnAdopcionGatoAngel.setMascota(gatoAngel);
//        publicacionMascotaEnAdopcionGatoAngel.getPreguntasSistema().add(preguntaAdopcionSistemaGatoAngel);
//        publicacionMascotaEnAdopcionGatoAngel.getPreguntasOrganizacion().add(preguntaConRespuestaGatoAngel);

        //4 bis

        PublicacionMascotaEnAdopcion publicacionMascotaGatoNico = new PublicacionMascotaEnAdopcion();
        publicacionMascotaGatoNico.setMascota(gatoNico);
        publicacionMascotaGatoNico.getPreguntasSistema().add(preguntaAdopcionSistemaGatoAngel);
        publicacionMascotaGatoNico.getPreguntasOrganizacion().add(preguntaConRespuestaGatoAngel);

        //5
//        Mascota perroMiguel = new Mascota();
//        perroMiguel.setNombre("Miguel");
//
//        PublicacionMascotaEnAdopcion publicacionMascotaEnAdopcionPerroMiguel = new PublicacionMascotaEnAdopcion();
//        publicacionMascotaEnAdopcionPerroMiguel.setMascota(perroMiguel);
//        publicacionMascotaEnAdopcionPerroMiguel.getPreguntasSistema().add(preguntaAdopcionSistemaPerroMiguel);
//        publicacionMascotaEnAdopcionPerroMiguel.getPreguntasOrganizacion().add(preguntaConRespuestaPerroMiguel);

        //5 bis

        PublicacionMascotaEnAdopcion publicacionMascotaPerroEsteban  = new PublicacionMascotaEnAdopcion();
        publicacionMascotaPerroEsteban.setMascota(perroEst);
        publicacionMascotaPerroEsteban.getPreguntasSistema().add(preguntaAdopcionSistemaPerroMiguel);
        publicacionMascotaPerroEsteban.getPreguntasOrganizacion().add(preguntaConRespuestaPerroMiguel);


        //6
//        Mascota gatoEnrique = new Mascota();
//        gatoEnrique.setNombre("Enrique");
//
//        PublicacionMascotaEnAdopcion publicacionMascotaEnAdopcionGatoEnrique = new PublicacionMascotaEnAdopcion();
//        publicacionMascotaEnAdopcionGatoEnrique.setMascota(gatoEnrique);
//        publicacionMascotaEnAdopcionGatoEnrique.getPreguntasSistema().add(preguntaAdopcionSistemaGatoEnrique);
//        publicacionMascotaEnAdopcionGatoEnrique.getPreguntasOrganizacion().add(preguntaConRespuestaGatoEnrique);

        //6 bis

        PreguntaOrganizacion pregOrgGatoFede = new PreguntaOrganizacion();
        pregOrgGatoFede.setPregunta("que tipo de animal es?");
        PreguntaConRespuesta pregRespGatoFede = new PreguntaConRespuesta();
        pregRespGatoFede.setPregunta(pregOrgGatoFede);
        pregRespGatoFede.setRespuesta("gato");

        PublicacionMascotaEnAdopcion publicacionMascotaGatoFede = new PublicacionMascotaEnAdopcion();
        publicacionMascotaGatoFede.setMascota(gatoFede);
        publicacionMascotaGatoFede.getPreguntasSistema().add(preguntaAdopcionSistemaGatoEnrique);
        publicacionMascotaGatoFede.getPreguntasOrganizacion().add(preguntaConRespuestaGatoEnrique);
        publicacionMascotaGatoFede.getPreguntasOrganizacion().add(pregRespGatoFede);

        //Publicacion Mascota Perdida

        //7
        MascotaPerdida perroDeRoberto = new MascotaPerdida();
        perroDeRoberto.setEstadoMascota("Perdido");
        Usuario u_roberto = new Usuario();
        u_roberto.setNombreUsuario("rober");
        u_roberto.setContrasenia("rober123");
        Persona roberto = new Persona();
        roberto.setUsuario(u_roberto);
        Contacto c_roberto = new Contacto();
        c_roberto.setEmail("roberto@email.com");
        c_roberto.setTelefono(77777777);
        roberto.getContactos().add(c_roberto);
        perroDeRoberto.setRescatista(roberto);

        PublicacionMascotaPerdida publicacionMascotaPerdidaPerroDeRoberto = new PublicacionMascotaPerdida();
        publicacionMascotaPerdidaPerroDeRoberto.setMascotaPerdida(perroDeRoberto);

        //8
        MascotaPerdida gatoDeValeria = new MascotaPerdida();
        gatoDeValeria.setEstadoMascota("Perdido");
        Usuario u_valeria = new Usuario();
        u_valeria.setNombreUsuario("vale");
        u_valeria.setContrasenia("vale123");
        Persona valeria = new Persona();
        valeria.setUsuario(u_valeria);
        Contacto c_valeria = new Contacto();
        c_valeria.setEmail("valeria@email.com");
        c_valeria.setTelefono(88888888);
        valeria.getContactos().add(c_valeria);
        gatoDeValeria.setRescatista(valeria);

        PublicacionMascotaPerdida publicacionMascotaPerdidaGatoDeValeria = new PublicacionMascotaPerdida();
        publicacionMascotaPerdidaGatoDeValeria.setMascotaPerdida(gatoDeValeria);

        //9
        MascotaPerdida perroDeJimena = new MascotaPerdida();
        perroDeJimena.setEstadoMascota("Encontrado");
        Usuario u_jimena = new Usuario();
        u_jimena.setNombreUsuario("jime");
        u_jimena.setContrasenia("jime123");
        Persona jimena = new Persona();
        jimena.setUsuario(u_jimena);
        Contacto c_jimena = new Contacto();
        c_jimena.setEmail("jimena@email.com");
        c_jimena.setTelefono(99999999);
        jimena.getContactos().add(c_jimena);
        perroDeJimena.setRescatista(jimena);

        PublicacionMascotaPerdida publicacionMascotaPerdidaPerroDeJimena = new PublicacionMascotaPerdida();
        publicacionMascotaPerdidaPerroDeJimena.setMascotaPerdida(perroDeJimena);

        //MATCH PUBLICACIONES

        //match para omar con gatoFede
        MatchPublicaciones match1 = new MatchPublicaciones();
        match1.setPregAdopSist(preguntaAdopcionSistemaGatoEnrique);
        match1.setPreferencia(preferenciaOmar);

        //match para omar con gatoFede
        MatchPublicaciones match2 = new MatchPublicaciones();
        match2.setComodidad(comodidadOmar);
        match2.setPregOrganizacion(pregRespGatoFede);

        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.getEntityManager().persist(perroFede); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(gatoFede); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(perroNico); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(gatoNico); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(perroEst); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(gatoEst); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(federico); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(nicolas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(esteban); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_federico); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_nicolas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_esteban); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_federico); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_nicolas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_esteban); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_sol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_lucas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_omar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_roberto); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_valeria); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(u_jimena); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaOrganizacionGatoAngel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaConRespuestaGatoAngel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaOrganizacionPerroMiguel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaConRespuestaPerroMiguel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaOrganizacionGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaConRespuestaGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaSistemaGatoAngel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaAdopcionSistemaGatoAngel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaConRespuestaGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaAdopcionSistemaPerroMiguel); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaConRespuestaGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preguntaAdopcionSistemaGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(sol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(comodidadSol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preferenciaSol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(caracteristicaSol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preferenciaSol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionBusquedaAdopcionSol); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(omar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(comodidadOmar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(caracteristicaOmar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preferenciaOmar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionBusquedaAdopcionOmar); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(lucas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(comodidadLucas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(caracteristicaLucas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(preferenciaLucas); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionBusquedaAdopcionLucas); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(gatoAngel); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(publicacionMascotaEnAdopcionGatoAngel); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(perroMiguel); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(publicacionMascotaEnAdopcionPerroMiguel); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(gatoEnrique); //SE PREPARA INSERT
//        EntityManagerHelper.getEntityManager().persist(publicacionMascotaEnAdopcionGatoEnrique); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(pregOrgGatoFede);
        EntityManagerHelper.getEntityManager().persist(pregRespGatoFede);
        EntityManagerHelper.getEntityManager().persist(match1);
        EntityManagerHelper.getEntityManager().persist(match2);
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaGatoNico);
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaGatoFede);
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaPerroEsteban);
        EntityManagerHelper.getEntityManager().persist(perroDeRoberto); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(roberto); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_roberto); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaPerdidaPerroDeRoberto); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(gatoDeValeria); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(valeria); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_valeria); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaPerdidaGatoDeValeria); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(perroDeJimena); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(jimena); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(c_jimena); //SE PREPARA INSERT
        EntityManagerHelper.getEntityManager().persist(publicacionMascotaPerdidaPerroDeJimena); //SE PREPARA INSERT

        EntityManagerHelper.commit(); //SE EJECUTAN TODAS LAS SENTENCIAS
    }*/
}
