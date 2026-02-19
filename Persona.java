// Clase abstracta que representa a cualquier persona en la biblioteca
public abstract class Persona {

    protected String nombre; // nombre de la persona
    protected String id;     // id unico de la persona

    // Constructor
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    // Devuelve el id
    public String getId() {
        return id;
    }

    // Metodo abstracto para que cada tipo de persona diga su tipo
    public abstract String getTipo();
}
