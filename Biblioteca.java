import java.util.ArrayList;

// Clase que maneja toda la biblioteca
public class Biblioteca {

    private ArrayList<Libro> libros;       // lista de libros
    private ArrayList<Persona> personas;   // lista de personas
    private ArrayList<Prestamo> prestamos; // lista de prestamos activos

    // Constructor inicializa listas
    public Biblioteca() {
        libros = new ArrayList<>();
        personas = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // Agrega un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Agrega una persona (usuario o bibliotecario)
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    // Devuelve la lista de libros
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    // Muestra todos los libros
    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    // Registra un prestamo
    public void registrarPrestamo(Persona persona, Libro libro) {

        if (!(persona instanceof Usuario)) {
            System.out.println("Solo los usuarios pueden solicitar prestamos.");
            return;
        }

        Usuario usuario = (Usuario) persona;

        if (!libro.estaDisponible()) {
            System.out.println("El libro no esta disponible.");
            return;
        }

        if (!usuario.puedePedirPrestamo()) {
            System.out.println("El usuario alcanzo el limite de prestamos.");
            return;
        }

        // todo correcto, registramos prestamo
        libro.prestar();
        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamos.add(prestamo);
        usuario.agregarPrestamo(prestamo);

        System.out.println("Prestamo registrado correctamente.");
    }

    // Registra la devolucion de un libro
    public void registrarDevolucion(Persona persona, Libro libro) {

        if (!(persona instanceof Usuario)) {
            System.out.println("Solo los usuarios pueden devolver libros.");
            return;
        }

        Usuario usuario = (Usuario) persona;

        // buscamos el prestamo correspondiente
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo p = prestamos.get(i);
            if (p.getLibro() == libro) {
                p.registrarDevolucion();
                usuario.devolverPrestamo(p);
                prestamos.remove(i); // quitamos prestamo activo
                System.out.println("Devolucion registrada correctamente.");
                return;
            }
        }

        System.out.println("No se encontro el prestamo.");
    }

    // Genera reporte general
    public void generarReporte() {
        System.out.println("\n--- REPORTE GENERAL ---");
        mostrarLibros();
        System.out.println("\nPrestamos activos:");
        for (Prestamo p : prestamos) {
            System.out.println(p.getInfoPrestamo());
        }
    }
}
