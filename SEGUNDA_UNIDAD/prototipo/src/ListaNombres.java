import java.util.ArrayList;
import java.util.Scanner;
public class ListaNombres {
    public static void agregarNombres(ArrayList<String> lista, String nombre) {
        lista.add(nombre);
    }
    public static void mostrarLista(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Lista de nombres:");
            for (String nombres : lista) {
                System.out.println(nombres);
            }
        }
    }
    public static void eliminarNombre(ArrayList<String> lista, int indice) {
        if(indice>=0&&indice<lista.size()){
            lista.remove(indice);
            System.out.println("Nombre eliminado");
        }
        else{
            System.out.println("Índice fuera de rango");
        }
    }
    public static ArrayList <String> filtrarNombreLetra(ArrayList<String>lista, char letra) {
        ArrayList <String> filtrados = new ArrayList <>();
        for(String nombre : lista){
            if(nombre.startsWith(String.valueOf(letra))){
                filtrados.add(nombre);
            }
        }
        return filtrados;
    }
    public static void buscarNombre(ArrayList<String> lista, String nombre) {
        int posicion=lista.indexOf(nombre);
        if(posicion!=-1){
            System.out.println("El nombre "+nombre+" esta en la posición "+posicion);
        }
        else{
            System.out.println("nombre no encontrado");
        }
    }
    public static void modificarNombre(ArrayList<String> lista,int indice, String nuevoNombre) {
        if(indice>=0&&indice< lista.size()){
            lista.set(indice,nuevoNombre);
            System.out.println("Nombre modificado en el índice: "+indice+" ");
        }
        else{
            System.out.println("Índice fuera de rango");
        }
    }
    public static void tamañoLista(ArrayList<String> lista){
        System.out.println("Tamaño de la lista de nombres "+lista.size());
    }
    public static void borrarLista(ArrayList<String> lista){
        lista.clear();
        System.out.println("Lista de nombres borrada completamente");
    }
    public static void verificarNombre(ArrayList<String>lista,String nombre){
        if(lista.contains(nombre)){
            System.out.println("El nombre "+nombre+"existe en la lista");
        }
        else {
            System.out.println("El nombre "+nombre+" no existe en la lista");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        agregarNombres(nombres, "Juan");
        agregarNombres(nombres, "Pedro");
        agregarNombres(nombres, "Yony");
        agregarNombres(nombres, "Kenji");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar nombre");
            System.out.println("2. Mostrar nombres");
            System.out.println("3. Eliminar nombre por índice");
            System.out.println("4. Filtrar nombres por letra inicial");
            System.out.println("5. Buscar nombre");
            System.out.println("6. Modificar nombre");
            System.out.println("7. Mostrar tamaño de la lista");
            System.out.println("8. Borrar todos los nombres");
            System.out.println("9. Verificar existencia de un nombre");
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
                    System.out.print("Ingresa un nombre para agregar: ");
                    String nombreAgregar = sc.nextLine();
                    agregarNombres(nombres, nombreAgregar);
                    break;

                case 2:
                    mostrarLista(nombres);
                    break;

                case 3:
                    System.out.print("Ingresa el índice del nombre a eliminar: ");
                    try {
                        int indiceEliminar = Integer.parseInt(sc.nextLine());
                        eliminarNombre(nombres, indiceEliminar);
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresa la letra para filtrar: ");
                    String letraInput = sc.nextLine();
                    if (letraInput.length() > 0) {
                        char letra = letraInput.charAt(0);
                        ArrayList<String> filtrados = filtrarNombreLetra(nombres, letra);
                        if (filtrados.isEmpty()) {
                            System.out.println("No hay nombres que empiecen con '" + letra + "'.");
                        } else {
                            System.out.println("Nombres que empiezan con '" + letra + "':");
                            for (String f : filtrados) {
                                System.out.println(f);
                            }
                        }
                    } else {
                        System.out.println("No ingresaste una letra válida.");
                    }
                    break;

                case 5:
                    System.out.print("Ingresa el nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    buscarNombre(nombres, nombreBuscar);
                    break;

                case 6:
                    System.out.print("Ingresa el índice del nombre a modificar: ");
                    try {
                        int indiceMod = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingresa el nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        modificarNombre(nombres, indiceMod, nuevoNombre);
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    tamañoLista(nombres);
                    break;

                case 8:
                    borrarLista(nombres);
                    break;

                case 9:
                    System.out.print("Ingresa el nombre a verificar: ");
                    String nombreVerificar = sc.nextLine();
                    verificarNombre(nombres, nombreVerificar);
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