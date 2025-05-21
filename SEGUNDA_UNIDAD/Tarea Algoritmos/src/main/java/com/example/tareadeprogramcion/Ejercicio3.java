package com.example.tareadeprogramcion;

import java.util.Scanner;

public class Ejercicio3 {

    public static boolean evaluarCarrera(String[] acciones, String pista) {
        StringBuilder pistaFinal = new StringBuilder(pista);
        boolean superada = true;

        for (int i = 0; i < pista.length(); i++) {
            char tramo = pista.charAt(i);
            String accion = acciones[i];

            if (tramo == '_' && accion.equals("run")) {

            } else if (tramo == '|' && accion.equals("jump")) {

            } else {
                superada = false;
                if (tramo == '_' && accion.equals("jump")) {
                    pistaFinal.setCharAt(i, 'x');
                } else if (tramo == '|' && accion.equals("run")) {
                    pistaFinal.setCharAt(i, '/');
                }
            }
        }

        System.out.println("resultado final de la pista:");
        System.out.println(pistaFinal.toString());
        return superada;
    }

    public static void main(String[] args) {
        Scanner kya = new Scanner(System.in);

        System.out.print("ingresa la pista (solo '_' y '|'): ");
        String pista = kya.nextLine();

        int longitud = pista.length();
        String[] acciones = new String[longitud];

        System.out.println("ingresa las acciones una por una (run o jump):");
        for (int i = 0; i < longitud; i++) {
            System.out.print("acción para el tramo " + (i + 1) + ": ");
            acciones[i] = kya.nextLine().trim();
        }

        boolean exito = evaluarCarrera(acciones, pista);

        if (exito) {
            System.out.println("¡la carrera fue superada correctamente!");
        } else {
            System.out.println("la carrera no fue superada");
        }
    }
}
