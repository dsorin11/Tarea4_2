package ahorcado;

import java.util.Date;

//Clase para representar una partida
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
