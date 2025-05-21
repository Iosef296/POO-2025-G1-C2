package com.example.tareadeprogramcion;

public class Ejercicio1 {
    public static void main(String[] args) {
        long[] fibo = new long[50];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < 50; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        for (long num : fibo) {
            System.out.println(num + " ");
        }
    }
}