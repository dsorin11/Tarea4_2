package estudio;

public class variables {

	public static void main(String[] args) {
		String nombre= "David Soriano Navarro";
		System.out.println("Mi nombre es " + nombre );
		System.out.println("Mi nombre tiene " + nombre.length() + " letras");
		System.out.println("La primera letra de mi nombre es " + nombre.charAt(0));
		
		int ultima_letra;
		ultima_letra=nombre.length();
		System.out.println("La ultima letra es la " + nombre.charAt(ultima_letra-1));
	}

}
