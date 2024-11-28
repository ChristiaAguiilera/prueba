//La clase Profesor usa uno de los pilares de la programacion orientada a objetos que es la herencia. 


package com.poo.Usuario;
import com.poo.Sistema;
import com.poo.Enums.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Usuario {
    // Atributos específicos
    private String facultad;
    private ArrayList<String> listaMaterias; // Lista de materias que imparte el profesor

    // Constructor
    public Profesor(int codigo, String cedula, String nombre, String apellido, String usuario, String contrasena,
            String correo, String facultad, ArrayList<String> listaMaterias) {
        super(codigo, cedula, nombre, apellido, usuario, contrasena, correo, Rol.PROFESOR);

        this.facultad = facultad;
        this.listaMaterias = listaMaterias;
    }

    // Métodos específicos
    public void reservar(String materia) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseas reservar un laboratorio, aula o auditorio?"); //SOlicita input para tipo de espacio
        String decision = sc.nextLine();
        ArrayList<String> lineas = LeeFichero("Espacio.txt"); //carga los espacios
        ArrayList<String> profesores = LeeFichero("Profesores.txt"); //carga los profesores

        if (decision.toUpperCase() == "AULA") {
            System.out.println("Las aulas disponibles son las siguientes: ");
            // Se presentan las aulas disponibles
            for (int i = 0; i < lineas.size(); i++) {
                String[] palabras = lineas.get(i).split("|");
                if (palabras[4] != "RESERVADO" & palabras[1] == "AULA") {
                    System.out.println(palabras[2] + " - " + palabras[3]);
                }
            }
            // Se muestran materias del profesor
            for (int i = 0; i < profesores.size(); i++) {
                // Se verifica el nombre del profesor
                String[] profe = profesores.get(i).split("|");
                if (getNombre().equals(profe[2])) {
                    System.out.println(profe[5]);
                    break; // Se utiliza para que no siga corriendo el for
                }
            }
            //Se recopilan los datos
            System.out.println("Para cual materia es la reserva?");
            String asignatura = sc.nextLine();

            System.out.println("Ingrese el nombre del aula que desee: ");
            String nombre = sc.nextLine();
            //Se pide input para crear la reserva
            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(asignatura, nombre, decision); //Envia correo
            } else {
                Sistema.mostrar_menu(this); //Vuelve al menu si no realiza la reserva

            }
        } else if (decision.toUpperCase() == "LABORATORIO") {
            // Se presentan las aulas disponibles
            for (int i = 0; i < lineas.size(); i++) {
                String[] palabras = lineas.get(i).split("|");
                if (palabras[4] != "RESERVADO" & palabras[1] == "LABORATORIO") {
                    System.out.println(palabras[2] + " - " + palabras[3]);
                }
            }
            // Se muestran materias del profesor
            for (int i = 0; i < profesores.size(); i++) {
                // Se verifica el nombre del profesor
                String[] profe = profesores.get(i).split("|");
                if (getNombre().equals(profe[2])) {
                    System.out.println(profe[5]);
                    break; // Se utiliza para que no siga corriendo el for
                }

            }
            System.out.println("Para cual materia es la reserva?");
            String asignatura = sc.nextLine();

            System.out.println("Ingrese el nombre del laboratorio que desee: ");
            String nombre = sc.nextLine();

            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();

            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(asignatura, nombre, decision);
            } else {
                Sistema.mostrar_menu(this);

            }
        } else if (decision.toUpperCase() == "AUDITORIO") {
            // Se presentan las aulas disponibles
            for (int i = 0; i < lineas.size(); i++) {
                String[] palabras = lineas.get(i).split("|");
                if (palabras[4] != "RESERVADO" & palabras[1] == "AUDITORIO") {
                    System.out.println(palabras[2] + " - " + palabras[3]);
                }
            }
            // Se muestran materias del profesor
            for (int i = 0; i < profesores.size(); i++) {
                // Se verifica el nombre del profesor
                String[] profe = profesores.get(i).split("|");
                if (getNombre().equals(profe[2])) {
                    System.out.println(profe[5]);
                    break; // Se utiliza para que no siga corriendo el for
                }
            }
            System.out.println("Para cual materia es la reserva?");
            String asignatura = sc.nextLine();

            System.out.println("Ingrese el nombre del laboratorio que desee: ");
            String nombre = sc.nextLine();

            System.out.println("Deseas crear la reserva?");
            String respuesta = sc.nextLine();

            if (respuesta.toUpperCase().equals("SI")) {
                enviar_correo(asignatura, nombre, decision);
            } else {
                Sistema.mostrar_menu(this);

            }

        } else {
            // Si no inserta un tipo valido se le muestra el menu nuevamente
            System.out.println("No valido vuelva a intentarlo");
            Sistema.mostrar_menu(this);
        }
        sc.close();
    }

    @Override
    public String toString() {
        return "Profesor {" +
                "Código: " + getCodigo() +
                ", Nombre: " + getNombre() + " " + getApellido() +
                ", Facultad: " + facultad +
                ", Materias: " + listaMaterias +
                "}";
    }

    // Getters y Setters
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<String> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public void reservar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservar'");
    }

}
