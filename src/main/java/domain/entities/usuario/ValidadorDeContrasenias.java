package domain.entities.usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//TODO: Revisar implementacion y actualizar con respecto al diagrama de clases
public class ValidadorDeContrasenias {

    private int margenDeRotacion;

    public void margenContraseniasAnteriores(int margenContraseniasAnteriores) {
        this.margenDeRotacion = margenContraseniasAnteriores;
    }

    public void cambiarContraseniaExistente(Usuario usuario,Boolean usuarioNuevo) throws IOException {

        ArrayList<String> contraseniasMenosSeguras = obtenerContraseniasMenosSeguras();

        System.out.println("Ingresar contraseña nueva:");
        String contraNueva = System.console().readLine();
        /*
          if(usuarioNuevo)
            ---crea la contraseña del domain.entities.usuario nuevo, y no compara con el historial de contraseñas---
          else
            ---cambia contraseñan de domain.entities.usuario existente y para validarla compara con el historial de contraseñas---

         */
//        TODO: Agregar funcionalidad para tener x intentos para ingresar contraseña nueva, sino no se cambia nada
        while(this.validarContrasenia(contraNueva,contraseniasMenosSeguras) && rotarContrasenia(contraNueva)){
            System.out.println("La contraseña ingresada no cumple con las restricciones. Ingrese una nueva contraseña:");
            contraNueva = System.console().readLine();
        }

//      TODO: tengo que agregar la contraseña anterior el archivo de historialPasswords

        usuario.setContrasenia(contraNueva);       //Agrega o cambia la contraseña correctamente
    }

//    TODO: Necesitamos cambiar el metodo para que lea un archivo(o json o txt) que tenga un hash con las contraseñas anteriores
    public boolean rotarContrasenia(String contrasenia){
        try{
            File file = new File("historialPasswords.txt");
            Scanner historialPasswords = new Scanner(file);
            ArrayList<String> contraseniasAntiguas = new ArrayList<>();

            //Supone que se actualizan las nuevas contraseñas al principio del file
            for (int i = 0; historialPasswords.hasNext() && i < margenDeRotacion; i++){
                contraseniasAntiguas.add( historialPasswords.next() );
            }
            historialPasswords.close();

            return ( contraseniasAntiguas.contains(contrasenia) );
        }catch(Exception ex){
            return false;
        }
    }

    public boolean estaEnElTop10000Passwords(String contrasenia, ArrayList<String> listaContrasenias){
        return (listaContrasenias.contains(contrasenia));
    }

    public boolean tieneMayuscula (String contrasenia){
        return (contrasenia.matches("[A-Z]"));
    }

    public boolean tieneMinuscula (String contrasenia){
        return (contrasenia.matches("[a-z]"));
    }

    public boolean tieneNumero (String contrasenia){
        return (contrasenia.matches("[0-9]"));
    }

    public boolean tieneMinimo8Caracteres (String contrasenia){
        return (contrasenia.length() >= 8);
    }

    public boolean validarContrasenia (String contrasenia, ArrayList<String> listaContrasenias) {
        return tieneMayuscula(contrasenia) && tieneMinuscula(contrasenia)
                && tieneNumero(contrasenia) && tieneMinimo8Caracteres(contrasenia)
                && !estaEnElTop10000Passwords(contrasenia, listaContrasenias);
    }

    public ArrayList<String> obtenerContraseniasMenosSeguras() throws IOException {
        //Esta parte intenta leer el .txt desde cualquier ubicacion y guardarlo en una lista
        InputStream archivo = ValidadorDeContrasenias.class.getResourceAsStream("/top10000passwords.txt");
        InputStreamReader archivoLector = new InputStreamReader(archivo);
        BufferedReader lector = new BufferedReader(archivoLector);
        String linea;

        ArrayList<String> contraseniasMenosSeguras = new ArrayList<>();

        while((linea = lector.readLine()) != null){
            contraseniasMenosSeguras.add(linea);
        }
        return contraseniasMenosSeguras;
    }
}
