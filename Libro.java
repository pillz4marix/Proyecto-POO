// Clase que representa un libro
public class Libro {

    private String titulo;
    private String autor;
    private boolean disponible; // true si el libro se puede prestar

    // Constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // al inicio siempre disponible
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    // Marca el libro como prestado
    public void prestar() {
        disponible = false;
    }

    // Marca el libro como disponible
    public void devolver() {
        disponible = true;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + (disponible ? " (Disponible)" : " (Prestado)");
    }
}
