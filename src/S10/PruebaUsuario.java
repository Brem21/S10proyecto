package S10;

import java.util.Scanner;

public class PruebaUsuario {
    public static void main(String[] args) {
        SistemaAcceso sistema = new SistemaAcceso();
        sistema.agregarUsuario(new Usuario("001", "Brem", "Suarez", "TI", "Alto"));
        sistema.agregarUsuario(new Usuario("002", "Esteban", "Morales", "Finanzas", "Medio"));
        sistema.agregarUsuario(new Usuario("003", "Leonardo", "Gomez", "Física", "Bajo"));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ver usuarios registrados");
            System.out.println("2. Ver intentos de acceso");
            System.out.println("3. Registrar intento de acceso");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> sistema.mostrarUsuarios();
                case 2 -> sistema.mostrarAccesos();
                case 3 -> {
                    System.out.print("Ingrese el código del usuario: ");
                    String codigo = scanner.nextLine();
                    System.out.print("¿El acceso fue exitoso? (true/false): ");
                    boolean exito = scanner.nextBoolean();
                    sistema.registrarAcceso(codigo, exito);
                }
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}