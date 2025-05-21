package com.example.tareadeprogramcion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ejercicio8 {

    public static String adviento(LocalDate fecha) {
        LocalDate inicio = LocalDate.of(2022, 12, 1);
        LocalDate fin = LocalDate.of(2022, 12, 24);
        if (fecha.isBefore(inicio)) {
            long dias = ChronoUnit.DAYS.between(fecha, inicio);
            return "Faltan " + dias + " días para el inicio del calendario";
        } else if (fecha.isAfter(fin)) {
            return "El calendario de adviento ha terminado";
        } else {
            long faltan = ChronoUnit.DAYS.between(fecha, fin);
            return "Regalo del día: 'Sorpresa tecnológica'. Faltan " + faltan + " días para que termine el calendario.";
        }
    }

    public static void main(String[] args) {
        System.out.println(adviento(LocalDate.of(2022, 12, 10)));
    }
}
