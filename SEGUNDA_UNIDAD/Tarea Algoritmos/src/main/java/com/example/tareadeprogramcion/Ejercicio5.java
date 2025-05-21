package com.example.tareadeprogramcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ejercicio5 {
    static Map<Integer, String> productos = Map.of(1, "Galleta", 2, "Agua", 3, "Chocolate");
    static Map<Integer, Integer> precios = Map.of(1, 120, 2, 100, 3, 150);
    static int[] monedas = new int[]{200, 100, 50, 10, 5};

    public static Object[] comprar(int[] dinero, int producto) {
        int total = 0;

        for(int m : dinero) {
            if (Arrays.stream(monedas).noneMatch((x) -> x == m)) {
                return new Object[]{"Moneda inválida", dinero};
            }

            total += m;
        }

        if (!productos.containsKey(producto)) {
            return new Object[]{"Producto no existe", dinero};
        } else {
            int precio = (Integer)precios.get(producto);
            if (total < precio) {
                return new Object[]{"Dinero insuficiente", dinero};
            } else {
                int vuelto = total - precio;
                List<Integer> devuelta = new ArrayList();
                int[] var13 = monedas;
                int var7 = var13.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    for(int m = var13[var8]; vuelto >= m; vuelto -= m) {
                        devuelta.add(m);
                    }
                }

                return new Object[]{productos.get(producto), devuelta.toArray(new Integer[0])};
            }
        }
    }

    public static void main(String[] args) {
        int[] dinero = new int[]{100, 50, 10};
        Object[] resultado = comprar(dinero, 3);
        System.out.println("Producto: " + String.valueOf(resultado[0]));
    }
}