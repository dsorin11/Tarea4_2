package estudio;
import java.util.*;

public class ProgramacionEstructurada {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int edad;
		char sexo;
		int tlf;
		
		System.out.println("Introduzca su edad");
		edad=scan.nextInt();
		System.out.println("Su sexo");
		sexo=scan.next().charAt(0);
		System.out.println("Su telefono");
		tlf=scan.nextInt();
		
		System.out.println("Su edad es "+ edad);
		System.out.println("Su sexo es "+ sexo);
		System.out.println("Su telefono es "+ tlf);

	}

}
