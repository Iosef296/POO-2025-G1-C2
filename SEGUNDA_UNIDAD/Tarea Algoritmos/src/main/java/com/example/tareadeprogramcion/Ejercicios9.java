package com.example.tareadeprogramcion;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Ejercicios9 {
    static Scanner sc;
    static Random rand;

    public static void main(String[] args) {
        String[] palabras = new String[]{"murcielago", "programador", "universidad", "teclado", "java", "computadora"};
        String palabra = palabras[rand.nextInt(palabras.length)];
        int intentos = 7;
        String oculta = ocultarLetras(palabra);
        char[] progreso = oculta.toCharArray();

        while(intentos > 0 && !String.valueOf(progreso).equals(palabra)) {
            System.out.println("Palabra: " + String.valueOf(progreso));
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Ingresa una letra o la palabra completa: ");
            String entrada = sc.nextLine().toLowerCase();
            if (entrada.length() != 1) {
                if (entrada.length() == palabra.length()) {
                    if (entrada.equals(palabra)) {
                        progreso = palabra.toCharArray();
                    } else {
                        --intentos;
                    }
                } else {
                    System.out.println("Entrada inválida.");
                }
            } else {
                char letra = entrada.charAt(0);
                boolean acierto = false;

                for(int i = 0; i < palabra.length(); ++i) {
                    if (palabra.charAt(i) == letra && progreso[i] == '_') {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }

                if (!acierto) {
                    --intentos;
                }
            }
        }

        if (String.valueOf(progreso).equals(palabra)) {
            System.out.println("¡Ganaste! La palabra era: " + palabra);
        } else {
            System.out.println("Perdiste. La palabra era: " + palabra);
        }

    }

    static String ocultarLetras(String palabra) {
        int maxOcultas = (int)((double)palabra.length() * 0.6);
        Set<Integer> posiciones = new HashSet();

        while(posiciones.size() < maxOcultas) {
            posiciones.add(rand.nextInt(palabra.length()));
        }

        char[] resultado = palabra.toCharArray();

        for(int pos : posiciones) {
            resultado[pos] = '_';
        }

        return new String(resultado);
    }

    static {
        sc = new Scanner(System.in);
        rand = new Random();
    }
}
