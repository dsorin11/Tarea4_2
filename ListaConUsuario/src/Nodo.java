public class Nodo {
    Usuario usuario;
    Nodo siguiente;

    public Nodo(Usuario usuario){
        this.usuario = usuario;
        this.siguiente = null;
    }
}