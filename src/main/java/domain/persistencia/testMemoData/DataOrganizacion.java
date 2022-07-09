package domain.persistencia.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.Organizacion.Organizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataOrganizacion {
    private static List<Organizacion> organizaciones = new ArrayList<>();

    public static List<EntidadPersistente> getList() {
        if (organizaciones.size() == 0) {
//
//            Organizacion org = new Organizacion();
//            org.setUsuario("orgUsuario");
//
//            org.setId(1);
//            org.setNombre("ORG");
//            addAll(org);
        }
        return (List<EntidadPersistente>) (List<?>) organizaciones;
    }

    private static void addAll(Organizacion... organizaciones) {
        Collections.addAll(DataOrganizacion.organizaciones, organizaciones);
    }
}
