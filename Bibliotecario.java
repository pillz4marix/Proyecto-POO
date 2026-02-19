public class Bibliotecario extends Persona {

    public Bibliotecario(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public String getTipo() {
        return "Bibliotecario";
    }
}
