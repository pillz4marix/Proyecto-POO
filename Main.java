import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        //Libros
        Libro libro1 = new Libro("Cien años de soledad", "García Márquez");
        Libro libro2 = new Libro("1984", "George Orwell");
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry");
        Libro libro4 = new Libro("Orgullo y prejuicio", "Jane Austen");
        Libro libro5 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        //Personas
        Usuario usuario1 = new Usuario("Ana", "U01");
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", "B01");

        biblioteca.agregarPersona(usuario1);
        biblioteca.agregarPersona(bibliotecario1);

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Usuario pide libro");
            System.out.println("3. Bibliotecario intenta pedir libro (prueba casting)");
            System.out.println("4. Devolver libro");
            System.out.println("5. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    biblioteca.mostrarLibros();
                    break;

                case 2:
                    biblioteca.registrarPrestamo(usuario1, libro1);
                    break;

                case 3:
                    biblioteca.registrarPrestamo(bibliotecario1, libro2);
                    break;

                case 4:
                    biblioteca.registrarDevolucion(usuario1, libro1);
                    break;

                case 5:
                    biblioteca.generarReporte();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
