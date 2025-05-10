
package itson.proyectofinal;

public class Arista {
    
    private final Nodo destino;
    private final double peso; 

    public Arista(Nodo destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Nodo getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "→ " + destino.getNombre() + " (" + peso + ")";
    }
}

