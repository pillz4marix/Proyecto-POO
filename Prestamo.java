import java.time.LocalDate;

// Clase que representa un prestamo de un libro
public class Prestamo {

    private Usuario usuario;       // usuario que pide el libro
    private Libro libro;           // libro prestado
    private LocalDate fechaPrestamo; // fecha en que se hizo el prestamo
    private LocalDate fechaDevolucion; // fecha de devolucion, null si no se devuelve

    // Constructor
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    // Registra la devolucion del libro
    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
        libro.devolver(); // se marca como disponible
    }

    // Devuelve el libro de este prestamo
    public Libro getLibro() {
        return libro;
    }

    // Devuelve la info del prestamo en texto
    public String getInfoPrestamo() {
        return "Usuario: " + usuario.getNombre() +
                " | Libro: " + libro.getTitulo() +
                " | Fecha prestamo: " + fechaPrestamo +
                " | Fecha devolucion: " +
                (fechaDevolucion != null ? fechaDevolucion : "Pendiente");
    }
}
