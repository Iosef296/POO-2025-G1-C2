package com.example.tareadeprogramcion;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner kya = new Scanner(System.in);
        System.out.print("Ingresa un texto: ");
        String texto = kya.nextLine();

        int vocales = 0;
        int consonantes = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }

        System.out.println("Cantidad de vocales: " + vocales);
        System.out.println("Cantidad de consonantes: " + consonantes);
    }
}
