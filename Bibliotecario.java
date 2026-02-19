// Clase que representa a un bibliotecario
public class Bibliotecario extends Persona {

    public Bibliotecario(String nombre, String id) {
        super(nombre, id);
    }

    // Devuelve el tipo de persona
    @Override
    public String getTipo() {
        return "Bibliotecario";
    }
}
