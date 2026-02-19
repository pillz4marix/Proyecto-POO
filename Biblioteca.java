import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Persona> personas;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        personas = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void registrarPrestamo(Persona persona, Libro libro) {

        if (!(persona instanceof Usuario)) {
            System.out.println("Solo los usuarios pueden solicitar préstamos.");
            return;
        }

        Usuario usuario = (Usuario) persona;

        if (!libro.estaDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        if (!usuario.puedePedirPrestamo()) {
            System.out.println("El usuario alcanzó el límite de préstamos.");
            return;
        }

        libro.prestar();
        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamos.add(prestamo);
        usuario.agregarPrestamo(prestamo);

        System.out.println("Préstamo registrado correctamente.");
    }

    public void registrarDevolucion(Persona persona, Libro libro) {

        if (!(persona instanceof Usuario)) {
            System.out.println("Solo los usuarios pueden devolver libros.");
            return;
        }

        Usuario usuario = (Usuario) persona;

        for (Prestamo p : prestamos) {
            if (p.getLibro() == libro) {
                p.registrarDevolucion();
                usuario.devolverPrestamo(p);
                prestamos.remove(p);
                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("No se encontró el préstamo.");
    }

    public void generarReporte() {
        System.out.println("\n--- REPORTE GENERAL ---");
        mostrarLibros();
        System.out.println("\nPréstamos activos:");
        for (Prestamo p : prestamos) {
            System.out.println(p.getInfoPrestamo());
        }
    }
}
