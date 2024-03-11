package ahorcado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Clase para manejar el ranking
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
