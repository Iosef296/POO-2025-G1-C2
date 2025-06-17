import java.util.ArrayList;
import java.util.Scanner;

class Cancion {
    String titulo;
    String artista;
    String genero;
    String letra;

    public Cancion(String titulo, String artista, String genero, String letra) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nArtista: " + artista + "\nGénero: " + genero + "\nLetra:\n" + letra;
    }
}

public class canciones {

    public static void agregarCancion(ArrayList<Cancion> lista, Cancion cancion) {
        lista.add(cancion);
    }

    public static void mostrarCanciones(ArrayList<Cancion> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista de canciones está vacía.");
        } else {
            System.out.println("Lista de canciones:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Índice: " + i);
                System.out.println(lista.get(i));
                System.out.println("-------------------------");
            }
        }
    }

    public static void eliminarCancion(ArrayList<Cancion> lista, int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            System.out.println("Canción eliminada.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public static void buscarPorTitulo(ArrayList<Cancion> lista, String titulo) {
        boolean encontrada = false;
        for (Cancion c : lista) {
            if (c.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Canción encontrada:");
                System.out.println(c);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontró ninguna canción con ese título.");
        }
    }

    public static void buscarPorArtista(ArrayList<Cancion> lista, String artista) {
        boolean encontrada = false;
        for (Cancion c : lista) {
            if (c.artista.equalsIgnoreCase(artista)) {
                System.out.println("Canción encontrada:");
                System.out.println(c);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se encontró ninguna canción de ese artista.");
        }
    }

    public static void modificarCancion(ArrayList<Cancion> lista, int indice, Scanner sc) {
        if (indice >= 0 && indice < lista.size()) {
            System.out.print("Nuevo título: ");
            String nuevoTitulo = sc.nextLine();
            System.out.print("Nuevo artista: ");
            String nuevoArtista = sc.nextLine();
            System.out.print("Nuevo género: ");
            String nuevoGenero = sc.nextLine();

            System.out.println("Escribe la nueva letra (escribe 'FIN' para terminar):");
            StringBuilder sb = new StringBuilder();
            String linea;
            while (!(linea = sc.nextLine()).equalsIgnoreCase("FIN")) {
                sb.append(linea).append("\n");
            }
            String nuevaLetra = sb.toString();

            lista.set(indice, new Cancion(nuevoTitulo, nuevoArtista, nuevoGenero, nuevaLetra));
            System.out.println("Canción modificada.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public static void borrarTodasLasCanciones(ArrayList<Cancion> lista) {
        lista.clear();
        System.out.println("Todas las canciones han sido eliminadas.");
    }

    public static void mostrarCantidadCanciones(ArrayList<Cancion> lista) {
        System.out.println("Cantidad de canciones: " + lista.size());
    }

    public static void main(String[] args) {
        ArrayList<Cancion> canciones = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        canciones.add(new Cancion("Imagine", "John Lennon", "Rock", "Imagine all the people..."));
        canciones.add(new Cancion("Thriller", "Michael Jackson", "Pop", "Cause this is thriller, thriller night..."));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar canción");
            System.out.println("2. Mostrar canciones");
            System.out.println("3. Eliminar canción por índice");
            System.out.println("4. Buscar canción por título");
            System.out.println("5. Buscar canción por artista");
            System.out.println("6. Modificar canción");
            System.out.println("7. Mostrar cantidad de canciones");
            System.out.println("8. Eliminar todas las canciones");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Género: ");
                    String genero = sc.nextLine();

                    System.out.println("Escribe la letra de la canción (escribe 'FIN' para terminar):");
                    StringBuilder sb = new StringBuilder();
                    String linea;
                    while (!(linea = sc.nextLine()).equalsIgnoreCase("FIN")) {
                        sb.append(linea).append("\n");
                    }
                    String letra = sb.toString();

                    agregarCancion(canciones, new Cancion(titulo, artista, genero, letra));
                    break;

                case 2:
                    mostrarCanciones(canciones);
                    break;

                case 3:
                    System.out.print("Índice de la canción a eliminar: ");
                    try {
                        int indiceEliminar = Integer.parseInt(sc.nextLine());
                        eliminarCancion(canciones, indiceEliminar);
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Título de la canción: ");
                    String tituloBuscar = sc.nextLine();
                    buscarPorTitulo(canciones, tituloBuscar);
                    break;

                case 5:
                    System.out.print("Artista: ");
                    String artistaBuscar = sc.nextLine();
                    buscarPorArtista(canciones, artistaBuscar);
                    break;

                case 6:
                    System.out.print("Índice de la canción a modificar: ");
                    try {
                        int indiceModificar = Integer.parseInt(sc.nextLine());
                        modificarCancion(canciones, indiceModificar, sc);
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    mostrarCantidadCanciones(canciones);
                    break;

                case 8:
                    borrarTodasLasCanciones(canciones);
                    break;

                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}