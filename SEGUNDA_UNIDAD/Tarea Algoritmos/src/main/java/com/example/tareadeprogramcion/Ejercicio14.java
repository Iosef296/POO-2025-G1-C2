package com.example.tareadeprogramcion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner kya = new Scanner(System.in);
        System.out.print("Ingresa tu fecha de cumpleaños (formato MM-DD): ");
        String[] partes = kya.nextLine().split("-");
        int mes = Integer.parseInt(partes[0]);
        int dia = Integer.parseInt(partes[1]);
        LocalDate hoy = LocalDate.now();
        LocalDate cumpleEsteAnio = LocalDate.of(hoy.getYear(), mes, dia);
        if (cumpleEsteAnio.isBefore(hoy) || cumpleEsteAnio.isEqual(hoy)) {
            cumpleEsteAnio = cumpleEsteAnio.plusYears(1L);
        }

        long diasFaltantes = ChronoUnit.DAYS.between(hoy, cumpleEsteAnio);
        System.out.println("Faltan " + diasFaltantes + " días para tu próximo cumpleaños.");
    }
}
