package com.example.tareadeprogramcion;

public class Ejercicio15 {
    public static void main(String[] args) {
        int inicio = 1;
        int fin = 500;
        System.out.println("Números palíndromos entre " + inicio + " y " + fin + ":");

        for(int i = inicio; i <= fin; ++i) {
            if (esPalindromo(i)) {
                System.out.println(i);
            }
        }

    }

    static boolean esPalindromo(int num) {
        String original = String.valueOf(num);
        String invertido = (new StringBuilder(original)).reverse().toString();
        return original.equals(invertido);
    }
}