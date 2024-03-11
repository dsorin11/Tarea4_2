package estudioavanzado;

import java.io.*;
import java.util.*;

// Clase para representar una palabra con su nivel de dificultad
class Palabra {
    private String palabra;
    private String dificultad;

    public Palabra(String palabra, String dificultad) {
        this.palabra = palabra;
        this.dificultad = dificultad;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getDificultad() {
        return dificultad;
    }
}

// Clase para representar una partida
class Partida {
    private String usuario;
    private Palabra palabra;
    private int intentosFallidos;
    private Date fecha;

    public Partida(String usuario, Palabra palabra, int intentosFallidos) {
        this.usuario = usuario;
        this.palabra = palabra;
        this.intentosFallidos = intentosFallidos;
        this.fecha = new Date();
    }

    public String getUsuario() {
        return usuario;
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public Date getFecha() {
        return fecha;
    }
}

// Clase para manejar el ranking
class Ranking {
    private List<Partida> partidas;

    public Ranking() {
        this.partidas = new ArrayList<>();
    }

    public void agregarPartida(Partida partida) {
        partidas.add(partida);
    }

    public void mostrarRanking() {
        // Ordenar las partidas por dificultad, intentos fallidos y fecha
        Collections.sort(partidas, (p1, p2) -> {
            if (!p1.getPalabra().getDificultad().equals(p2.getPalabra().getDificultad())) {
                return p1.getPalabra().getDificultad().compareTo(p2.getPalabra().getDificultad());
            } else if (p1.getIntentosFallidos() != p2.getIntentosFallidos()) {
                return Integer.compare(p1.getIntentosFallidos(), p2.getIntentosFallidos());
            } else {
                return p1.getFecha().compareTo(p2.getFecha());
            }
        });

        // Mostrar el ranking
        System.out.println("=== RANKING ===");
        for (Partida partida : partidas) {
            System.out.println("Usuario: " + partida.getUsuario() + " | Palabra: " + partida.getPalabra().getPalabra() +
                    " | Dificultad: " + partida.getPalabra().getDificultad() + " | Intentos fallidos: " + partida.getIntentosFallidos() +
                    " | Fecha: " + partida.getFecha());
        }
    }
}

public class Ahorcado {
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
