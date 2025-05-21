package com.example.tareadeprogramcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] konami = new String[]{"arriba", "arriba", "abajo", "abajo", "izquierda", "derecha", "izquierda", "derecha", "b", "a"};
        List<String> entrada = new ArrayList();
        System.out.println("Introduce el código (una palabra por línea):");

        do {
            String input = sc.nextLine().toLowerCase();
            entrada.add(input);
            if (entrada.size() > konami.length) {
                entrada.remove(0);
            }
        } while(!Arrays.equals(entrada.toArray(), konami));

        System.out.println("¡Código Konami detectado!");
    }
}
