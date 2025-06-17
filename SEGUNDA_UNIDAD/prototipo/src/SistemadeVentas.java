import java.util.ArrayList;
import java.util.Scanner;{

static class SistemadeVentas {

    String CafeteriaPradoc;
    String cafes;
    String bebidas;
    String  tortas;

    public Cancion(String CafePradoc, String cafes, String bebidas, String tortas) {
        this.CafeteriaPradoc=CafeteriaPradoc;
        this. cafes= cafes ;
        this.bebidas = bebidas;
        this.tortas = tortas;
    }

    @Override
    public String toString() {
        return "CafetriaPradoc : " + CafeteriaPradoc+
                "\ncafes: " + cafes +
                "\nbebidas : " + bebidas +
                "\ntortas:\n" + tortas;
    }
}

public static void agregarcafes(ArrayList<Cafeteria.pradoc> lista, String , String cafes, String bebidas , String tortas) {
    lista.add(new ListaCanciones.Cancion(titulo, artista, genero, letra));
    System.out.println("Canción agregada.");
}

public static void mostrarCanciones(ArrayList<ListaCanciones.Cancion> lista) {
    if (lista.isEmpty()) {
        System.out.println("La lista de canciones está vacía.");
    } else {
        System.out.println("\nLista de canciones:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Índice: " + i);
            System.out.println(lista.get(i));
            System.out.println("-------------------------");
        }
    }
}

public static void eliminarCancion(ArrayList<ListaCanciones.Cancion> lista, int indice) {
    if (indice >= 0 && indice < lista.size()) {
        lista.remove(indice);
        System.out.println("Canción eliminada.");
    } else {
        System.out.println("Índice fuera de rango.");
    }
}

public static void buscarPorTitulo(ArrayList<ListaCanciones.Cancion> lista, String titulo) {
    boolean encontrado = false;
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).titulo.equalsIgnoreCase(titulo)) {
            System.out.println("Encontrada en el índice " + i + ":");
            System.out.println(lista.get(i));
            encontrado = true;
        }
    }
    if (!encontrado) {
        System.out.println("No se encontró ninguna canción con ese título.");
    }
}

public static void buscarPorArtista(ArrayList<ListaCanciones.Cancion> lista, String artista) {
    boolean encontrado = false;
    for (ListaCanciones.Cancion c : lista) {
        if (c.artista.equalsIgnoreCase(artista)) {
            System.out.println(c);
            System.out.println("-------------------------");
            encontrado = true;
        }
    }
    if (!encontrado) {
        System.out.println("No se encontró ninguna canción de ese artista.");
    }
}

public static void modificarCancion(ArrayList<ListaCanciones.Cancion> lista, int indice, String nuevoTitulo, String nuevoArtista, String nuevoGenero, String nuevaLetra) {
    if (indice >= 0 && indice < lista.size()) {
        lista.set(indice, new ListaCanciones.Cancion(nuevoTitulo, nuevoArtista, nuevoGenero, nuevaLetra));
        System.out.println("Canción modificada.");
    } else {
        System.out.println("Índice fuera de rango.");
    }
}

public static void cantidadCanciones(ArrayList<ListaCanciones.Cancion> lista) {
    System.out.println("Cantidad de canciones: " + lista.size());
}

public static void eliminarTodas(ArrayList<ListaCanciones.Cancion> lista) {
    lista.clear();
    System.out.println("Todas las canciones han sido eliminadas.");
}

public static void mostrarLetraPorIndice(ArrayList<ListaCanciones.Cancion> lista, int indice) {
    if (indice >= 0 && indice < lista.size()) {
        ListaCanciones.Cancion c = lista.get(indice);
        System.out.println("Letra de \"" + c.titulo + "\" de " + c.artista + ":\n");
        System.out.println(c.letra);
    } else {
        System.out.println("Índice fuera de rango.");
    }
}

public static void main(String[] args) {
    ArrayList<ListaCanciones.Cancion> canciones = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean salir = false;

    agregarCancion(canciones, "Imagine", "John Lennon", "Rock", "\nImagine there's no heaven\nIt's easy if you try\nNo hell below us\nAbove us, only sky\n \nImagine all the people\nLivin' for today\nAh\n \nImagine there's no countries\nIt isn't hard to do\nNothing to kill or die for\nAnd no religion, too\n \nImagine all the people\nLivin' life in peace\nYou\n \nYou may say I'm a dreamer\nBut I'm not the only one\nI hope someday you'll join us\nAnd the world will be as one\n \nImagine no possessions\nI wonder if you can\nNo need for greed or hunger\nA brotherhood of man\n \nImagine all the people\nSharing all the world\nYou\n \nYou may say I'm a dreamer\nBut I'm not the only one\nI hope someday you'll join us\nAnd the world will live as one\n");
    agregarCancion(canciones, "Seven Days", "Rosendale", "Pop", "\nI met her on the internet\nA tender mom of two\nSent emails back and forth\nA couple photos too\n \nAnd she could tell that I was hurt\nShe saw my frozen smile\nAsked what was going wrong\nSo I wrote with teary eyes\n \nI lie here in my bed\nSo no one else can see\nThe monster that I have become\nA sad anomaly\n \nI think my mind is broken\nI don't doubt I'm unhinged\nI fell deep into darkness\nNow my weeks are looking grim\n \nThe first day cuts me to the bone\nThe second leaves a bruise\nThe third day I wish I was dead\nThe third day I wish I was dead\nAnd when the fifth and sixth day come\nI've got no damn to give\nBut the seventh day still comes around\nAnd I go through it all again\nI thought I might have scared her off\nWent days with no reply\nWeeks later she responded\nTo my own surprise\n \nShe said it's okay I've been there too\nIt's just a part of life\nI fell deep into darkness but\nSomehow I still survived\n \nShe said\nThe first year cut me to the bone\nThe second left a bruise\nAnd dark thoughts clouded up my mind\nThe third and fourth years too\nBut when the fifth and sixth years came\nI saw a little light\nIn seven years you'll realize\nSometimes it just takes time\n \nTo be honest since we talked\nI'm not much better yet\nBut maybe that's all just because\nI'm only a few years in\n \n.....");

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
        System.out.println("9. Ver solo la letra de una canción");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        int opcion;
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
                System.out.println("Letra (puede ser larga):");
                String letra = sc.nextLine();
                agregarCancion(canciones, titulo, artista, genero, letra);
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
                System.out.print("Título a buscar: ");
                String tituloBuscar = sc.nextLine();
                buscarPorTitulo(canciones, tituloBuscar);
                break;

            case 5:
                System.out.print("Artista a buscar: ");
                String artistaBuscar = sc.nextLine();
                buscarPorArtista(canciones, artistaBuscar);
                break;

            case 6:
                System.out.print("Índice de la canción a modificar: ");
                try {
                    int indiceMod = Integer.parseInt(sc.nextLine());
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = sc.nextLine();
                    System.out.print("Nuevo artista: ");
                    String nuevoArtista = sc.nextLine();
                    System.out.print("Nuevo género: ");
                    String nuevoGenero = sc.nextLine();
                    System.out.println("Nueva letra:");
                    String nuevaLetra = sc.nextLine();
                    modificarCancion(canciones, indiceMod, nuevoTitulo, nuevoArtista, nuevoGenero, nuevaLetra);
                } catch (NumberFormatException e) {
                    System.out.println("Índice inválido.");
                }
                break;

            case 7:
                cantidadCanciones(canciones);
                break;

            case 8:
                eliminarTodas(canciones);
                break;

            case 9:
                System.out.print("Índice de la canción para ver su letra: ");
                try {
                    int indiceLetra = Integer.parseInt(sc.nextLine());
                    mostrarLetraPorIndice(canciones, indiceLetra);
                } catch (NumberFormatException e) {
                    System.out.println("Índice inválido.");
                }
                break;

            case 0:
                salir = true;
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opción inválida, intenta de nuevo.");
        }
    }

    sc.close();
}
}