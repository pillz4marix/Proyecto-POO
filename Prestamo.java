import java.time.LocalDate;

public class Prestamo {

    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
        libro.devolver();
    }

    public Libro getLibro() {
        return libro;
    }

    public String getInfoPrestamo() {
        return "Usuario: " + usuario.getNombre() +
                " | Libro: " + libro.getTitulo() +
                " | Fecha préstamo: " + fechaPrestamo +
                " | Fecha devolución: " +
                (fechaDevolucion != null ? fechaDevolucion : "Pendiente");
    }
}
