package com.example.tareadeprogramcion;

public class Ejercicio10 {
    public static void main(String[] args) {
        int rango = 100;

        for(int i = 2; i <= rango - 2; ++i) {
            if (esPrimo(i) && esPrimo(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }

    }

    static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        } else {
            for(int i = 2; (double)i <= Math.sqrt((double)n); ++i) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
