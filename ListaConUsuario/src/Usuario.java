import java.util.Scanner;

public class Usuario {
    int id;
    String nombre;
    String apellidos;
    String dni;
    String email;
    String direc;
    String telf;

    public Usuario(int id, String nombre, String apellidos, String dni, String email, String direc, String telf){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email=email;
        this.direc = direc;
        this.telf = telf;
    }

    public String getApellidos() {
        return apellidos;
    }
    public String getDirec() {
        return direc;
    }
    public String getDni() {
        return dni;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelf() {
        return telf;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDirec(String direc) {
        this.direc = direc;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTelf(String telf) {
        this.telf = telf;
    }

    public static Usuario crearUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el id de usuario");
        int id = sc.nextInt();
        System.out.println("Escriba el nombre de usuario");
        String nombre = sc.nextLine();
        System.out.println("Escriba los apellidos del usuario");
        String apellidos = sc.nextLine();
        System.out.println("Escriba el dni del usuario");
        String dni = sc.nextLine();
        System.out.println("Escriba el email del usuario");
        String email = sc.nextLine();
        System.out.println("Escriba la dirección del usuario");
        String direc = sc.nextLine();
        System.out.println("Escriba el telf del usuario");
        String telf = sc.nextLine();

        Usuario usuario = new Usuario(id, nombre, apellidos, dni, email, direc, telf);
        return usuario;
    }

    public void mostrar(){
        System.out.println("------Usuario: " + getId() + "------");
        System.out.println("El id de usuario es: " + getId());
        System.out.println("El nombre del usuario es: " + getNombre());
        System.out.println("Los apellidos del usuario son: " + getApellidos());
        System.out.println("La dirección del usuario es: " + getDirec());
        System.out.println("El dni del usuario es: " + getDni());
        System.out.println("Los apellidos del usuario son: " + getEmail());
        System.out.println("El teléfono del usuario es: " + getTelf());    
        System.out.println();    
    }
}