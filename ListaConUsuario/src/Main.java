public class Main {

     public static void main(String[] args) {
        
        Lista lista = new Lista();

        Usuario nuevoUsuario = Usuario.crearUsuario();
        lista.add(nuevoUsuario);
        lista.mostrarLista();
        nuevoUsuario = Usuario.crearUsuario();
        lista.add(nuevoUsuario);
        lista.mostrarLista();


     }
}