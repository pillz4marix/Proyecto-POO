import java.util.ArrayList;

// Clase que representa a un usuario de la biblioteca
public class Usuario extends Persona {

    private ArrayList<Prestamo> prestamos; // prestamos activos del usuario
    private final int LIMITE_PRESTAMOS = 2; // limite de prestamos por usuario

    // Constructor
    public Usuario(String nombre, String id) {
        super(nombre, id);
        prestamos = new ArrayList<>(); // inicializamos la lista vacia
    }

    // Devuelve true si el usuario puede pedir otro libro
    public boolean puedePedirPrestamo() {
        return prestamos.size() < LIMITE_PRESTAMOS;
    }

    // Agrega un prestamo a la lista
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // Elimina un prestamo cuando se devuelve un libro
    public void devolverPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    // Devuelve todos los prestamos del usuario
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public String getTipo() {
        return "Usuario";
    }
}
