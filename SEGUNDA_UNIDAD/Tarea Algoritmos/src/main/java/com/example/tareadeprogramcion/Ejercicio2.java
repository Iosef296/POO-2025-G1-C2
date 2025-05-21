package com.example.tareadeprogramcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ejercicio2 {

    public static int diasEntreFechas(String fecha1, String fecha2) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate f1 = LocalDate.parse(fecha1, formatter);
            LocalDate f2 = LocalDate.parse(fecha2, formatter);
            return (int) Math.abs(ChronoUnit.DAYS.between(f1, f2));
        } catch (Exception e) {
            throw new Exception("Fecha inválida");
        }


    }

    public static void main(String[] args) throws Exception {
        System.out.println(diasEntreFechas("01/05/2023", "10/05/2023"));
    }
}
