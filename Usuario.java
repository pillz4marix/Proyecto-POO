import java.util.ArrayList;

public class Usuario extends Persona {

    private ArrayList<Prestamo> prestamos;
    private final int LIMITE_PRESTAMOS = 2;

    public Usuario(String nombre, String id) {
        super(nombre, id);
        prestamos = new ArrayList<>();
    }

    public boolean puedePedirPrestamo() {
        return prestamos.size() < LIMITE_PRESTAMOS;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void devolverPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    @Override
    public String getTipo() {
        return "Usuario";
    }
}
