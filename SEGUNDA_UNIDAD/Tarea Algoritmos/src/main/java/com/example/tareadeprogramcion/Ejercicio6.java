package com.example.tareadeprogramcion;

import java.util.Map;

public class Ejercicio6 {

    public static double calcularDanio(String tipoAtacante, String tipoDefensor, int ataque, int defensa) {
        Map<String, Map<String, Double>> efectividad = Map.of("Agua", Map.of("Fuego", (double)2.0F, "Planta", (double)0.5F, "Eléctrico", (double)1.0F, "Agua", (double)0.5F), "Fuego", Map.of("Planta", (double)2.0F, "Agua", (double)0.5F, "Fuego", (double)0.5F, "Eléctrico", (double)1.0F), "Planta", Map.of("Agua", (double)2.0F, "Fuego", (double)0.5F, "Planta", (double)0.5F, "Eléctrico", (double)1.0F), "Eléctrico", Map.of("Agua", (double)2.0F, "Planta", (double)1.0F, "Fuego", (double)1.0F, "Eléctrico", (double)0.5F));
        double factor = (Double)((Map)efectividad.get(tipoAtacante)).getOrDefault(tipoDefensor, (double)1.0F);
        return (double)50.0F * ((double)ataque / (double)defensa) * factor;
    }

    public static void main(String[] args) {
        System.out.println("Daño: " + calcularDanio("Agua", "Fuego", 80, 60));
    }
}

