public class Lista {
    private Nodo cabeza;
    
    public Lista(){
        cabeza = null;
    }

    public void add(Usuario usuario){
        Nodo nuevo = new Nodo(usuario);
        Nodo temp = cabeza;

        if(cabeza != null){
            while(temp.siguiente != null){
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        } else {
            cabeza = nuevo;
        }
    }

    public void mostrarLista(){
        Nodo temp = cabeza;

        if(cabeza != null){
            while (temp != null) {
                temp.usuario.mostrar();
                temp = temp.siguiente;
            }
        }
    }

	public void mostrarUsuarioPos(int pos) {
	
	}	

	public Usuario obtenerUsuarioPos(int pos) {	
		Usuario temp = null;
		return(temp);
	}

	public int quitarUsuarioPos(int pos) {
		return(0);
	}

	public int buscarDni(String dni) {
		Nodo actual = cabeza;
		int pos = 0;
		
		while (actual != null) {
			if(actual.usuario.getDni().equals(dni)) {
				return pos;
			}
			actual = actual.siguiente;
			pos++;
		}
		return -1;
	}

	public int buscarUsuario(Usuario usuario) {
		Nodo actual = cabeza;
		Usuario usuarioActual = null;
		int pos = 0;
		
	while (actual != null) {
		if(usuarioActual.getId() == usuario.getId() 
		&& usuarioActual.getNombre().equals(usuario.getNombre())
		&& usuarioActual.getApellidos().equals(usuario.getApellidos())
		&& usuarioActual.getDni().equals(usuario.getDni())
		&& usuarioActual.getEmail().equals(usuario.getEmail())
		&& usuarioActual.getDirec().equals(usuario.getDirec())
		&& usuarioActual.getTelf().equals(usuario.getTelf())
		)
		{
		return pos;
	}
	actual = actual.siguiente;
	pos++;
	}
	return -1;
	}

	public void vaciar() {
	
	}
}