import java.util.ArrayList;
import java.util.Scanner;

public class CRUDConArrayList {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ CRUD ---");
            System.out.println("1. Agregar nombre");
            System.out.println("2. Ver nombres");
            System.out.println("3. Modificar nombre");
            System.out.println("4. Eliminar nombre");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1: // Crear
                    System.out.print("Ingresa el nombre a agregar: ");
                    String nuevoNombre = scanner.nextLine();
                    nombres.add(nuevoNombre);
                    System.out.println("Nombre agregado correctamente.");
                    break;

                case 2: // Leer
                    System.out.println("Lista de nombres:");
                    if (nombres.isEmpty()) {
                        System.out.println("No hay nombres registrados.");
                    } else {
                        for (int i = 0; i < nombres.size(); i++) {
                            System.out.println((i + 1) + ". " + nombres.get(i));
                        }
                    }
                    break;

                case 3: // Actualizar
                    System.out.print("Ingresa el número del nombre a modificar: ");
                    int indiceModificar = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpia el buffer
                    if (indiceModificar >= 0 && indiceModificar < nombres.size()) {
                        System.out.print("Ingresa el nuevo nombre: ");
                        String nombreModificado = scanner.nextLine();
                        nombres.set(indiceModificar, nombreModificado);
                        System.out.println("Nombre modificado correctamente.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4: // Eliminar
                    System.out.print("Ingresa el número del nombre a eliminar: ");
                    int indiceEliminar = scanner.nextInt() - 1;
                    if (indiceEliminar >= 0 && indiceEliminar < nombres.size()) {
                        nombres.remove(indiceEliminar);
                        System.out.println("Nombre eliminado correctamente.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
