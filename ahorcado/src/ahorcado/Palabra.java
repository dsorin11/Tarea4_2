package ahorcado;

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