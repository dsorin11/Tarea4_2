package ahorcado;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class ahorcado {
    private static final String PALABRAS_FILE = "palabras.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ranking ranking = new Ranking();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    jugar(scanner, ranking);
                    break;
                case 2:
                    ranking.mostrarRanking();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1- Nuevo juego");
        System.out.println("2- Ver ranking");
        System.out.println("0- Finalizar");
        System.out.print("Seleccione una opción: ");
    }

    private static void jugar(Scanner scanner, Ranking ranking) {
        System.out.print("Introduce tu nombre de usuario: ");
        String usuario = scanner.next();

        System.out.println("Selecciona una dificultad (fácil, normal, difícil): ");
        String dificultad = scanner.next();

        List<Palabra> palabrasDisponibles = obtenerPalabrasPorDificultad(dificultad);

        if (palabrasDisponibles.isEmpty()) {
            System.out.println("No hay palabras disponibles para la dificultad seleccionada.");
            return;
        }

        // Seleccionar una palabra aleatoria
        Random random = new Random();
        Palabra palabraSeleccionada = palabrasDisponibles.get(random.nextInt(palabrasDisponibles.size()));

        String palabraSecreta = palabraSeleccionada.getPalabra();
        String palabraAdivinada = "_".repeat(palabraSecreta.length());
        int intentosFallidos = 0;

        // Iniciar el juego
        System.out.println("¡Adivina la palabra!");
        while (intentosFallidos < 5 && palabraAdivinada.contains("_")) {
            System.out.println("Palabra: " + palabraAdivinada);
            System.out.println("Intentos restantes: " + (5 - intentosFallidos));
            System.out.print("Introduce una letra o la palabra completa: ");
            String entrada = scanner.next().toLowerCase();

            if (entrada.length() == 1) {
                // El usuario ingresó una letra
                if (palabraSecreta.contains(entrada)) {
                    // La letra está en la palabra
                    StringBuilder sb = new StringBuilder(palabraAdivinada);
                    for (int i = 0; i < palabraSecreta.length(); i++) {
                        if (palabraSecreta.charAt(i) == entrada.charAt(0)) {
                            sb.setCharAt(i, entrada.charAt(0));
                        }
                    }
                    palabraAdivinada = sb.toString();
                } else {
                    // La letra no está en la palabra
                    System.out.println("¡Letra incorrecta!");
                    intentosFallidos++;
                }
            } else if (entrada.equals(palabraSecreta)) {
                // El usuario intentó adivinar la palabra completa
                palabraAdivinada = palabraSecreta;
            } else {
                // La entrada no es válida
                System.out.println("Entrada inválida. Inténtalo de nuevo.");
            }
        }

        if (!palabraAdivinada.contains("_")) {
            System.out.println("¡Felicidades, has adivinado la palabra!");
        } else {
            System.out.println("¡Oh no! Has agotado tus intentos. La palabra era: " + palabraSecreta);
        }

        // Guardar la partida en el ranking
        ranking.agregarPartida(new Partida(usuario, palabraSeleccionada, intentosFallidos));
    }

    private static List<Palabra> obtenerPalabrasPorDificultad(String dificultad) {
        List<Palabra> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PALABRAS_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("#");
                if (partes.length == 2 && partes[1].equalsIgnoreCase(dificultad)) {
                    palabras.add(new Palabra(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabras;
    }


}