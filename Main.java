import java.util.ArrayList;
import java.util.Scanner;

// Clase principal que ejecuta el sistema
public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Creamos libros
        Libro libro1 = new Libro("Cien años de soledad", "Garcia Marquez");
        Libro libro2 = new Libro("1984", "George Orwell");
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupery");
        Libro libro4 = new Libro("Orgullo y prejuicio", "Jane Austen");
        Libro libro5 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        // Creamos personas
        Usuario usuario1 = new Usuario("Ana", "U01");
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", "B01");

        biblioteca.agregarPersona(usuario1);
        biblioteca.agregarPersona(bibliotecario1);

        int opcion;

        do {
            // Menu principal
            System.out.println("\n SISTEMA DE BIBLIOTECA");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Usuario pide libro");
            System.out.println("3. Bibliotecario intenta pedir libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    biblioteca.mostrarLibros();
                    break;

                case 2:
                    // Usuario pide libro
                    System.out.println("Elige el libro a pedir:");
                    ArrayList<Libro> libros = biblioteca.getLibros();
                    for (int i = 0; i < libros.size(); i++) {
                        System.out.println((i + 1) + ". " + libros.get(i));
                    }
                    int libroIndex = scanner.nextInt() - 1;
                    if (libroIndex >= 0 && libroIndex < libros.size()) {
                        biblioteca.registrarPrestamo(usuario1, libros.get(libroIndex));
                    } else {
                        System.out.println("Libro invalido.");
                    }
                    break;

                case 3:
                    // Bibliotecario intenta pedir libro
                    System.out.println("Intentando que un bibliotecario pida libro...");
                    biblioteca.registrarPrestamo(bibliotecario1, libro1);
                    break;

                case 4:
                    // Devolver libro
                    ArrayList<Prestamo> prestamosUsuario = usuario1.getPrestamos();
                    if (prestamosUsuario.isEmpty()) {
                        System.out.println("No tienes libros prestados.");
                        break;
                    }
                    System.out.println("Elige el libro a devolver:");
                    for (int i = 0; i < prestamosUsuario.size(); i++) {
                        System.out.println((i + 1) + ". " + prestamosUsuario.get(i).getLibro().getTitulo());
                    }
                    int devolverIndex = scanner.nextInt() - 1;
                    if (devolverIndex >= 0 && devolverIndex < prestamosUsuario.size()) {
                        biblioteca.registrarDevolucion(usuario1, prestamosUsuario.get(devolverIndex).getLibro());
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                    break;

                case 5:
                    biblioteca.generarReporte();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
